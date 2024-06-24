package com.example.productservice.repository;

import com.example.productservice.core.pagination.ProductCustomPage;
import com.example.productservice.entities.CategoryEntity;
import com.example.productservice.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    ProductCustomPage findAllByCategoryId(int categoryId);

    ProductCustomPage findAllByCategory(CategoryEntity category);
}
