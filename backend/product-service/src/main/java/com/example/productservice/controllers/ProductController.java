package com.example.productservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @PostMapping()
    public ResponseEntity<?> newProduct(/* @RequestBody ProductDTO product */) {
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductsById(@PathVariable("productId") String productId) {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/{category}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable("category") String category) {
        return ResponseEntity.status(200).build();
    }

    @PutMapping()
    public ResponseEntity<?> updateProduct(/* @RequestBody ProductDTO product */) {
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId) {
        return ResponseEntity.status(200).build();
    }
}