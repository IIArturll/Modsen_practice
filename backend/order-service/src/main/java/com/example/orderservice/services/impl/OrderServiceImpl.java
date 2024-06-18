package com.example.orderservice.services.impl;

import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.mappers.OrderMapper;
import com.example.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> getAll() {
        return List.of();
    }

    @Override
    public OrderDTO getById(Integer id) {
        return null;
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO update(Integer id, OrderDTO newOrderDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
