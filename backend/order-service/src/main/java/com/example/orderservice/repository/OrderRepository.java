package com.example.orderservice.repository;

import com.example.orderservice.enities.OrderEntity;
import com.example.orderservice.enities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findByCustomerId(int customerId);

    List<OrderEntity> findByCustomer(UserEntity user);
}
