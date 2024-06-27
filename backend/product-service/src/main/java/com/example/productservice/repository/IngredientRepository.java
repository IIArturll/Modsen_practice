package com.example.productservice.repository;

import com.example.productservice.entities.IngredientEntity;
import com.example.productservice.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<IngredientEntity, Integer> {
    Optional<IngredientEntity> findByName(String name);

//    List<IngredientEntity> findByProduct(ProductEntity product);

//    List<IngredientEntity> findByProductId(Integer productId);
}
