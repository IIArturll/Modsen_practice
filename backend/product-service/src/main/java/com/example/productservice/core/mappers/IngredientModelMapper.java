package com.example.productservice.core.mappers;

import com.example.productservice.core.dto.IngredientModelDTO;
import com.example.productservice.entities.IngredientModelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface IngredientModelMapper  {

    @Mapping(source = "ingredient.id", target = "ingredientId")
    IngredientModelDTO toDTO(IngredientModelEntity ingredientModelEntity);
}

