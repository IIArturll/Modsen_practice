package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.IngredientModelDTO;
import com.example.orderservice.enities.IngredientModelEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class IngredientModelMapper implements Function<IngredientModelEntity, IngredientModelDTO> {

    @Override
    public IngredientModelDTO apply(IngredientModelEntity ingredientModelEntity) {
        return new IngredientModelDTO(
                ingredientModelEntity.getId(),
                ingredientModelEntity.getIngredient().getId(),
                ingredientModelEntity.getWeight()
        );
    }
}
