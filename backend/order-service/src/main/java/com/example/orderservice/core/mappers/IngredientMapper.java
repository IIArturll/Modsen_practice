package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.IngredientDTO;
import com.example.orderservice.enities.IngredientEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientDTO toDTO(IngredientEntity ingredientEntity);
}
