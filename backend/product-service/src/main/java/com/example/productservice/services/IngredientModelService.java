package com.example.productservice.services;

import com.example.productservice.dto.IngredientModelDTO;

import java.util.List;

public interface IngredientModelService {

    List<IngredientModelDTO> getAll();

    IngredientModelDTO getById(Integer id);

    IngredientModelDTO create(IngredientModelDTO ingredientModelDTO);

    IngredientModelDTO update(Integer id, IngredientModelDTO ingredientModelDTO);

    void delete(Integer id);

}
