package com.example.orderservice.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record IngredientDTO(
        Integer id,

        @NotBlank
        @Size(min = 1, max = 255, message = "name should be between 1 to 255 characters")
        String name,

        @NotNull
        @Positive(message = "calories can't be negative")
        Integer calories,

        @NotNull
        @Positive(message = "protein can't be negative")
        Integer protein,

        @NotNull
        @Positive(message = "fats can't be negative")
        Integer fats,

        @NotNull
        @Positive(message = "carbs can't be negative")
        Integer carbs
) {

}