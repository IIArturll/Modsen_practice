package com.example.orderservice.mappers;

import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.enities.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OrderMapper implements Function<OrderEntity, OrderDTO> {

    private final ProductMapper productMapper;

    @Autowired
    public OrderMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public OrderDTO apply(OrderEntity orderEntity) {
        return new OrderDTO(
                orderEntity.getId(),
                orderEntity.getUser() != null ? orderEntity.getUser().getId() : null,
                orderEntity.getPrice(),
                orderEntity.getCooking_time(),
                orderEntity.getOrder_time(),
                orderEntity.getProducts()
                        .stream()
                        .map(productMapper)
                        .collect(Collectors.toList())
        );
    }
}