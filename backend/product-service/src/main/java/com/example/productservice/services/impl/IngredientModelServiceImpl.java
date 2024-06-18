package com.example.productservice.services.impl;


import com.example.productservice.mappers.IngredientModelDTOMapper;
import com.example.productservice.dto.IngredientModelDTO;
import com.example.productservice.services.IngredientModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientModelServiceImpl implements IngredientModelService {

    private final IngredientModelDTOMapper ingredientModelDTOMapper;

    @Autowired
    public IngredientModelServiceImpl(IngredientModelDTOMapper ingredientModelDTOMapper) {
        this.ingredientModelDTOMapper = ingredientModelDTOMapper;
    }

    @Override
    public List<IngredientModelDTO> getAll() {
        return List.of();
    }

    @Override
    public IngredientModelDTO getById(Integer id) {
        return null;
    }

    @Override
    public IngredientModelDTO create(IngredientModelDTO ingredientModelDTO) {
        return null;
    }

    @Override
    public IngredientModelDTO update(Integer id, IngredientModelDTO ingredientModelDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
