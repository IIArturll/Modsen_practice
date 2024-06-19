package com.example.productservice.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryDTO(
        Integer id,

        @NotBlank
        @Size(min = 1, max = 255, message = "name should be between 1 to 255 characters")
        String name,

        @NotBlank
        @Size(min = 1, max = 255, message = "description should be between 1 to 255 characters")
        String description
) {

}
