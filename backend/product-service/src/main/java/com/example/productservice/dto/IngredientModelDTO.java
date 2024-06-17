package com.example.productservice.dto;

import jakarta.validation.constraints.NotNull;


public class IngredientModelDTO {

    @NotNull(message = "id must not be null")
    private Integer id;

    @NotNull(message = "ingredientId must not be null")
    private Integer ingredientId;

    @NotNull
    private Integer weight;

    public IngredientModelDTO() {
    }

    public IngredientModelDTO(Integer id, Integer ingredientId, Integer weight) {
        this.id = id;
        this.ingredientId = ingredientId;
        this.weight = weight;
    }

    public @NotNull(message = "id must not be null") Integer getId() {
        return id;
    }

    public void setId(@NotNull(message = "id must not be null") Integer id) {
        this.id = id;
    }

    public @NotNull(message = "ingredientId must not be null") Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(@NotNull(message = "ingredientId must not be null") Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public @NotNull Integer getWeight() {
        return weight;
    }

    public void setWeight(@NotNull Integer weight) {
        this.weight = weight;
    }
}
