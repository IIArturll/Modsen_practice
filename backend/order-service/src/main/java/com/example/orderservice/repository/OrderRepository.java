package com.example.orderservice.repository;

import com.example.orderservice.core.pagination.OrderCustomPage;
import com.example.orderservice.enities.OrderEntity;
import com.example.orderservice.enities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    OrderCustomPage findByCustomerId(int customerId);

    OrderCustomPage findByCustomerId(UserEntity user);
}
