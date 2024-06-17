package com.example.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IngredientDTO {

    @NotNull(message = "id must not be empty")
    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    private Integer calories;

    @NotNull
    private Integer protein;

    @NotNull
    private Integer fats;

    @NotNull
    private Integer carbs;

    public IngredientDTO(){
    }

    public IngredientDTO(Integer id, String name, Integer calories, Integer protein, Integer fats, Integer carbs) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fats = fats;
        this.carbs = carbs;
    }

    public @NotNull(message = "id must not be empty") Integer getId() {
        return id;
    }

    public void setId(@NotNull(message = "id must not be empty") Integer id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotNull Integer getCalories() {
        return calories;
    }

    public void setCalories(@NotNull Integer calories) {
        this.calories = calories;
    }

    public @NotNull Integer getProtein() {
        return protein;
    }

    public void setProtein(@NotNull Integer protein) {
        this.protein = protein;
    }

    public @NotNull Integer getFats() {
        return fats;
    }

    public void setFats(@NotNull Integer fats) {
        this.fats = fats;
    }

    public @NotNull Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(@NotNull Integer carbs) {
        this.carbs = carbs;
    }
}
