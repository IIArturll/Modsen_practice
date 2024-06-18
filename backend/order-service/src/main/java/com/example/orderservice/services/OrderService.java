package com.example.orderservice.services;

import com.example.orderservice.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAll();

    OrderDTO getById(Integer id);

    OrderDTO create(OrderDTO orderDTO);

    OrderDTO update(Integer id, OrderDTO newOrderDto);

    void delete(Integer id);

}
