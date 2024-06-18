package com.example.productservice.core.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;

    @NotBlank()
    @Size(min = 1, max = 255, message = "Name should be between 1 and 255 characters")
    private String name;

    @NotNull
    private Integer weight;

    @NotNull
    private Integer categoryId;

    @NotNull
    @Positive(message = "calories can't be negative")
    private Integer calories;

    @NotNull
    @Positive(message = "protein can't be negative")
    private Integer protein;

    @NotNull
    @Positive(message = "fats can't be negative")
    private Integer fats;

    @NotNull
    @Positive(message = "carbs can't be negative")
    private Integer carbs;

    @NotNull
    @PositiveOrZero(message = "price can't be negative")
    private Double price;

    @NotNull(message = "ingredients must not be null")
    private List<IngredientModelDTO> ingredients;

}
