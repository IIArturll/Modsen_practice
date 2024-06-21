package com.example.orderservice.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record IngredientModelDTO(
        Integer id,

        @NotNull(message = "ingredientId must not be null")
        Integer ingredientId,

        @Positive(message = "weight can't be negative")
        Integer weight
) {

}