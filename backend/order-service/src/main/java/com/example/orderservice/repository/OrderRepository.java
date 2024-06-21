package com.example.orderservice.repository;

import com.example.orderservice.core.pagination.CustomPage;
import com.example.orderservice.enities.OrderEntity;
import com.example.orderservice.enities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    CustomPage<OrderEntity> findByCustomerId(int customerId);

    CustomPage<OrderEntity> findByCustomerId(UserEntity user);
}
