package com.example.orderservice.controllers;

import com.example.orderservice.core.dto.OrderDTO;
import com.example.orderservice.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody List<Integer> productIds) {
        return ResponseEntity.status(201).body(orderService.create(productIds));
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.status(200).body(orderService.getAll());
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsersOrders() {
        return ResponseEntity.status(200).body(orderService.getUserOrders());
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<?> getAllOrdersByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(orderService.getAllOrdersByUserId(userId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer orderId) {
        return ResponseEntity.status(200).body(orderService.getById(orderId));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<?> editOrder(@PathVariable("orderId") Integer orderId,
                                       @RequestBody List<Integer> productIds) {
        return ResponseEntity.status(201).body(orderService.update(orderId, productIds));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId) {
        orderService.delete(orderId);
        return ResponseEntity.status(200).build();
    }
}