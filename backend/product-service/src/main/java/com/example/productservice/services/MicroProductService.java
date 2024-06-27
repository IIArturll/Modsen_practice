package com.example.productservice.services;

import com.example.productservice.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface MicroProductService {
    Optional<ProductEntity> getProductById(Integer id);

    List<Optional<ProductEntity>> getProductByIds(List<Integer> ids);
}
