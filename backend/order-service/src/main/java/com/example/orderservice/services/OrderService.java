package com.example.orderservice.services;

import com.example.orderservice.core.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAll();

    OrderDTO getById(Integer id);

    List<OrderDTO> getUserOrders();

    List<OrderDTO> getAllOrdersByUserId(Integer userId);

    OrderDTO create(List<Integer> productIds);

    OrderDTO update(Integer id, List<Integer> productIds);

    void delete(Integer id);

}
