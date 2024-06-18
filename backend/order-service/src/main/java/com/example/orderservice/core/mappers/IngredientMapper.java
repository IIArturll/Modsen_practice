package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.IngredientDTO;
import com.example.orderservice.enities.IngredientEntity;
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
