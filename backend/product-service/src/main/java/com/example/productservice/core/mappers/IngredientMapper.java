package com.example.productservice.core.mappers;


import com.example.productservice.core.dto.IngredientDTO;
import com.example.productservice.entities.IngredientEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class IngredientMapper implements Function<IngredientEntity, IngredientDTO> {

    @Override
    public IngredientDTO apply(IngredientEntity ingredientEntity) {
        return new IngredientDTO(
                ingredientEntity.getId(),
                ingredientEntity.getName(),
                ingredientEntity.getCalories(),
                ingredientEntity.getProtein(),
                ingredientEntity.getFats(),
                ingredientEntity.getCarbs()
        );
    }
}
