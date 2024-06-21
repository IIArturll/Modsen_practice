package com.example.orderservice.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ProductDTO(
        Integer id,

        @NotBlank()
        @Size(min = 1, max = 255, message = "Name should be between 1 and 255 characters")
        String name,

        @NotNull
        Integer weight,

        @NotNull
        Integer categoryId,

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
        Integer carbs,

        @NotNull
        @PositiveOrZero(message = "price can't be negative")
        Double price,

        @NotNull(message = "ingredients must not be null")
        List<IngredientModelDTO> ingredients
) {

}