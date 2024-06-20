package com.example.productservice.services;

import com.example.productservice.core.dto.IngredientDTO;

import java.util.List;

public interface IngredientService {

    List<IngredientDTO> getAll();

    IngredientDTO getById(Integer id);

    IngredientDTO create(IngredientDTO ingredientDTO);

    IngredientDTO update(IngredientDTO ingredientDTO);

    void delete(Integer id);
}
