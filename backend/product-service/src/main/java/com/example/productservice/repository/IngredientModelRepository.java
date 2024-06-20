package com.example.productservice.repository;

import com.example.productservice.entities.IngredientModelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientModelRepository extends CrudRepository<IngredientModelEntity, Integer> {

}
