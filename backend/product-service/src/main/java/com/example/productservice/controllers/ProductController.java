package com.example.productservice.controllers;

import com.example.productservice.core.dto.ProductCreateUpdateDTO;
import com.example.productservice.core.dto.ProductDTO;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService productService) {
        this.service = productService;
    }


    @PostMapping()
    public ResponseEntity<?> newProduct(@RequestBody ProductCreateUpdateDTO product) {
        service.create(product);
        return ResponseEntity.status(201).build();
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.status(200).body(service.getAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductsById(@PathVariable("productId") Integer productId) {
        return ResponseEntity.status(200).body(service.getById(productId));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable("category") String category) {
        return ResponseEntity.status(200).body(service.getProductsByCategory(category));
    }

    @PutMapping()
    public ResponseEntity<?> updateProduct(@RequestBody ProductCreateUpdateDTO product) {
        service.update(product);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") Integer productId) {
        service.delete(productId);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/{productId}/{ingredientId}/{weight}")
    public ResponseEntity<?> addIngredient(@PathVariable("productId") Integer productId,
                                           @PathVariable("ingredientId") Integer ingredientId,
                                           @PathVariable("weight") Integer weight) {
        service.addIngredientToProduct(productId, ingredientId, weight);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/{productId}/{ingredientId}")
    public ResponseEntity<?> addIngredient(@PathVariable("productId") Integer productId,
                                           @PathVariable("ingredientId") Integer ingredientId) {
        service.removeIngredientFromProduct(productId, ingredientId);
        return ResponseEntity.status(200).build();
    }
}