package com.example.productservice.repository;

import com.example.productservice.entities.CategoryEntity;
import com.example.productservice.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllByCategoryId(int categoryId);

    List<ProductEntity> findAllByCategory(CategoryEntity category);
}
