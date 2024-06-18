package com.example.orderservice.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Size(min = 1, max = 255, message = "name should be between 1 to 255 characters")
    private String name;

    @NotNull
    private Integer calories;

    @NotNull
    private Integer protein;

    @NotNull
    private Integer fats;

    @NotNull
    private Integer carbs;

}