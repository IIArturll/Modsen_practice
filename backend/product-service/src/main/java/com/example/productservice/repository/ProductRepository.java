package com.example.productservice.repository;

import com.example.productservice.entities.CategoryEntity;
import com.example.productservice.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllByCategoryId(int categoryId);

    List<ProductEntity> findAllByCategory(CategoryEntity category);
}
