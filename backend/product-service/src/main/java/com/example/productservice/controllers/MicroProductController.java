package com.example.productservice.controllers;

import com.example.productservice.entities.ProductEntity;
import com.example.productservice.services.MicroProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/micro/product")
public class MicroProductController {
    private final MicroProductService microProductService;

    public MicroProductController(MicroProductService microProductService) {
        this.microProductService = microProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductEntity>> getProductById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(microProductService.getProductById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Optional<ProductEntity>>> getProductsByIds(@RequestParam List<Integer> ids) {
        return ResponseEntity.status(200).body(microProductService.getProductByIds(ids));
    }
}
