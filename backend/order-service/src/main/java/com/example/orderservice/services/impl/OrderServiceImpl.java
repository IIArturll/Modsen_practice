package com.example.orderservice.services.impl;

import com.example.orderservice.controllers.clients.ProductClient;
import com.example.orderservice.controllers.clients.UserClient;
import com.example.orderservice.core.dto.OrderDTO;
import com.example.orderservice.core.exceptions.NotFoundException;
import com.example.orderservice.core.exceptions.ProductsNotFoundException;
import com.example.orderservice.core.mappers.OrderMapper;
import com.example.orderservice.enities.OrderEntity;
import com.example.orderservice.enities.ProductEntity;
import com.example.orderservice.enities.UserEntity;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.services.OrderService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final ProductClient productClient;
    private final EntityManager entityManager;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository,
                            UserClient userClient, ProductClient productClient,
                            EntityManager entityManager) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.userClient = userClient;
        this.productClient = productClient;
        this.entityManager = entityManager;
    }

    @Override
    public List<OrderDTO> getAll() {
        List<OrderEntity> entities = (List<OrderEntity>) orderRepository.findAll();
        return entities.stream().map(orderMapper::toDTO).toList();
    }

    @Override
    public OrderDTO getById(Integer id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order with this id not found"));
        return orderMapper.toDTO(orderEntity);
    }

    @Override
    public List<OrderDTO> getUserOrders() {
        UserEntity userEntity = getAuthorizedUser();
        List<OrderEntity> userOrders = orderRepository.findByUserId(userEntity.getId());
        return userOrders.stream().map(orderMapper::toDTO).toList();
    }

    private UserEntity getAuthorizedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("Not authenticated");
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return userClient.getByEmail(username).getBody()
                .orElseThrow(() -> new NotFoundException("Can't find user with email: " + username));
    }

    @Override
    public List<OrderDTO> getAllOrdersByUserId(Integer userId) {
        userClient.getById(userId).getBody()
                .orElseThrow(() -> new NotFoundException("Can't find user with id: " + userId));
        List<OrderEntity> userOrders = orderRepository.findByUserId(userId);
        return userOrders.stream().map(orderMapper::toDTO).toList();
    }

    @Override
    public OrderDTO create(List<Integer> productIds) {
        UserEntity userEntity = getAuthorizedUser();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderTime(LocalDateTime.now());
        orderEntity.setCookingTime(1); // TODO: Calculate cooking time
        orderEntity.setUser(userEntity);
        loadEntitiesAndAssignAndCountPrice(productIds, orderEntity);

        OrderEntity savedOrder = orderRepository.save(orderEntity);
        return orderMapper.toDTO(savedOrder);
    }

    private void loadEntitiesAndAssignAndCountPrice(List<Integer> productIds,
                                                    OrderEntity orderEntity) {
        List<Optional<ProductEntity>> optionalProductList = productClient.getProductsByIds(productIds).getBody();
        if (optionalProductList == null || optionalProductList.isEmpty()) {
            throw new RuntimeException("List of products is empty");
        }

        ProductsNotFoundException productsNotFoundException = new ProductsNotFoundException();
        List<ProductEntity> productEntities = new ArrayList<>();
        double price = 0.0;
        for (int i = 0; i < optionalProductList.size(); i++) {
            Optional<ProductEntity> productEntityOpt = optionalProductList.get(i);
            if (productEntityOpt.isEmpty()) {
                productsNotFoundException.addProductId(productIds.get(i));
            } else {
                ProductEntity productEntity = entityManager.merge(productEntityOpt.get());
                productEntities.add(productEntity);
                price += productEntity.getPrice();
            }
        }
        if (!productsNotFoundException.getProductIds().isEmpty()) {
            throw productsNotFoundException;
        }
        orderEntity.setProducts(productEntities);
        orderEntity.setPrice(price);
    }

    @Override
    public OrderDTO update(Integer id, List<Integer> productIds) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order with this id not found"));
        loadEntitiesAndAssignAndCountPrice(productIds, orderEntity);
        OrderEntity savedOrder = orderRepository.save(orderEntity);
        return orderMapper.toDTO(savedOrder);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order with this id not found"));
        orderRepository.deleteById(id);
    }


}
