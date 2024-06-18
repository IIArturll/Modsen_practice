package com.example.productservice.services.impl;


import com.example.productservice.mappers.IngredientMapper;
import com.example.productservice.dto.IngredientDTO;
import com.example.productservice.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientMapper ingredientMapper;

    @Autowired
    public IngredientServiceImpl(IngredientMapper ingredientMapper) {
        this.ingredientMapper = ingredientMapper;
    }

    @Override
    public List<IngredientDTO> getAll() {
        return List.of();
    }

    @Override
    public IngredientDTO getById(Integer id) {
        return null;
    }

    @Override
    public IngredientDTO create(IngredientDTO ingredientDTO) {
        return null;
    }

    @Override
    public IngredientDTO update(Integer id, IngredientDTO ingredientDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
