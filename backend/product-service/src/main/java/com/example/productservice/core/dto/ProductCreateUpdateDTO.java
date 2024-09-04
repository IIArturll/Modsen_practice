package com.example.productservice.core.dto;

import jakarta.validation.constraints.*;

import java.util.List;

public record ProductCreateUpdateDTO(
        Integer id,

        @NotBlank()
        @Size(min = 1, max = 255, message = "Name should be between 1 and 255 characters")
        String name,

        @NotNull
        Integer categoryId,

        @NotNull
        @PositiveOrZero(message = "price can't be negative")
        Double price,

        @NotNull(message = "ingredients must not be null")
        List<IngredientModelCreateUpdateDTO> ingredients
) {
}
