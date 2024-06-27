package com.example.productservice.services.impl;

import com.example.productservice.core.exceptions.NotFoundException;
import com.example.productservice.core.mappers.IngredientMapper;
import com.example.productservice.core.dto.IngredientDTO;
import com.example.productservice.entities.IngredientEntity;
import com.example.productservice.repository.IngredientRepository;
import com.example.productservice.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientMapper ingredientMapper;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientMapper ingredientMapper,
                                 IngredientRepository ingredientRepository) {
        this.ingredientMapper = ingredientMapper;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<IngredientDTO> getAll() {
        List<IngredientEntity> ingredientEntities = (List<IngredientEntity>) ingredientRepository.findAll();
        return ingredientEntities.stream().map(ingredientMapper::toDTO).toList();
    }

    @Override
    public IngredientDTO getById(Integer id) {
        IngredientEntity ingredientEntity = ingredientRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Ingredient with this id not found"));
        return ingredientMapper.toDTO(ingredientEntity);
    }

    @Override
    public IngredientDTO create(IngredientDTO ingredientDTO) {
        IngredientEntity entity = ingredientMapper.toEntity(ingredientDTO);
        IngredientEntity save = ingredientRepository.save(entity);
        return ingredientMapper.toDTO(save);
    }

    @Override
    public IngredientDTO update(IngredientDTO ingredientDTO) {
        ingredientRepository.findById(ingredientDTO.id()).orElseThrow(
                ()-> new NotFoundException("Ingredient with this id not found"));
        IngredientEntity entity = ingredientMapper.toEntity(ingredientDTO);
        ingredientRepository.save(entity);
        return ingredientDTO;
    }

    @Override
    public void delete(Integer id) {
        ingredientRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Ingredient with this id not found"));
        ingredientRepository.deleteById(id);
    }
}
