package com.example.productservice.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record IngredientModelDTO(
        Integer id,

        @NotNull(message = "ingredient must not be null")
        IngredientDTO ingredient,

        @Positive(message = "weight can't be negative")
        Integer weight
) {

}
