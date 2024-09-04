package com.example.orderservice.controllers.clients;

import com.example.orderservice.enities.ProductEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "product-service", path = "/micro/product")
public interface ProductClient {
    @GetMapping("/{id}")
    ResponseEntity<Optional<ProductEntity>> getProductById(@PathVariable Integer id);

    @GetMapping("/")
    ResponseEntity<List<Optional<ProductEntity>>> getProductsByIds(@RequestParam List<Integer> ids);
}
