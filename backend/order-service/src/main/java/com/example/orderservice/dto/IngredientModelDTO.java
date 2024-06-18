package com.example.orderservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientModelDTO {

    private Integer id;

    @NotNull(message = "ingredientId must not be null")
    private Integer ingredientId;

    @NotNull
    private Integer weight;

}