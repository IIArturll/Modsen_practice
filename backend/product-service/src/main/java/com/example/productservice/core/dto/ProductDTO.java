package com.example.productservice.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private Integer calories;

    @NotNull
    private Integer protein;

    @NotNull
    private Integer fats;

    @NotNull
    private Integer carbs;

    @NotNull
    private Double price;

    @NotNull(message = "ingredients must not be null")
    private List<IngredientModelDTO> ingredients;

}
