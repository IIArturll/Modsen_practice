package com.example.productservice.repository;

import com.example.productservice.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findByName(String categoryName);
}
