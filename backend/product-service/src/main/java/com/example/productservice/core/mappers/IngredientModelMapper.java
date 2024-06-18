package com.example.productservice.core.mappers;

import com.example.productservice.core.dto.IngredientModelDTO;
import com.example.productservice.entities.IngredientModelEntity;
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
