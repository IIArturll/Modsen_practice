package com.example.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ProductDTO {

    @NotNull(message = "id must not be null")
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

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, Integer weight, Integer categoryId,
                      Integer calories, Integer protein, Integer fats,
                      Integer carbs, Double price, List<IngredientModelDTO> ingredients) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.categoryId = categoryId;
        this.calories = calories;
        this.protein = protein;
        this.fats = fats;
        this.carbs = carbs;
        this.price = price;
        this.ingredients = ingredients;
    }

    public @NotNull(message = "id must not be null") Integer getId() {
        return id;
    }

    public void setId(@NotNull(message = "id must not be null") Integer id) {
        this.id = id;
    }

    public @NotBlank() @Size(min = 1, max = 255, message = "Name should be between 1 and 255 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank() @Size(min = 1, max = 255, message = "Name should be between 1 and 255 characters") String name) {
        this.name = name;
    }

    public @NotNull Integer getWeight() {
        return weight;
    }

    public void setWeight(@NotNull Integer weight) {
        this.weight = weight;
    }

    public @NotNull Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull Integer categoryId) {
        this.categoryId = categoryId;
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

    public @NotNull Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull Double price) {
        this.price = price;
    }

    public @NotNull(message = "ingredients must not be null") List<IngredientModelDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(@NotNull(message = "ingredients must not be null") List<IngredientModelDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
