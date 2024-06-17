package com.example.orderservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @PostMapping("/")
    public ResponseEntity<?> createOrder() {
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsersOrders() {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<?> getAllOrdersByUserId(@PathVariable String userId) {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable String orderId) {
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<?> editOrder(@PathVariable String orderId) {
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable String orderId) {
        return ResponseEntity.status(200).build();
    }
}
