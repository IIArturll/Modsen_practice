package com.example.orderservice.services.impl;

import com.example.orderservice.mappers.IngredientModelMapper;
import com.example.productservice.dto.IngredientDTO;
import com.example.productservice.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientModelServiceImpl implements IngredientService {

    private final IngredientModelMapper ingredientModelMapper;

    @Autowired
    public IngredientModelServiceImpl(IngredientModelMapper ingredientModelMapper) {
        this.ingredientModelMapper = ingredientModelMapper;
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
