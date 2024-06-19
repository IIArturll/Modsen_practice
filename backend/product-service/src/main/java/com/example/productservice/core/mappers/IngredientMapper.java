package com.example.productservice.core.mappers;


import com.example.productservice.core.dto.IngredientDTO;
import com.example.productservice.entities.IngredientEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientDTO toDTO(IngredientEntity ingredientEntity);
}
