package com.example.productservice.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {

    private Integer id;

    @NotBlank
    @Size(min = 1, max = 255, message = "nameshould be between 1 to 255 characters")
    private String name;

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

}
