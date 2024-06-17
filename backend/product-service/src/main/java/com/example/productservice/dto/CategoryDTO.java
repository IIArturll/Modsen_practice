package com.example.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull(message = "id must not be empty")
    Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }
}
