package com.example.productservice.controllers;

import com.example.productservice.core.dto.CategoryDTO;
import com.example.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.service = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<?> newCategory(@RequestBody CategoryDTO category) {
        service.create(category);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.status(200).body(service.getAll());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("categoryId") Integer categoryId) {
        return ResponseEntity.status(200).body(service.getById(categoryId));
    }

    @PutMapping("/")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO category) {
        service.update(category);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        service.delete(categoryId);
        return ResponseEntity.status(200).build();
    }
}