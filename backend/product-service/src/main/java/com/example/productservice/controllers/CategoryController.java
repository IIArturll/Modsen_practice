package com.example.productservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @PostMapping("/")
    public ResponseEntity<?> newCategory() {
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getAllCategoriesById(@PathVariable("categoryId") String categoryId) {
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<?> updateProduct(@PathVariable("categoryId") String categoryId) {
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("categoryId") String categoryId) {
        return ResponseEntity.status(200).build();
    }
}