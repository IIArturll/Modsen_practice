package com.example.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Integer id;

    @NotBlank
    @Size(min = 1, max = 255, message = "name should be between 1 to 255 characters")
    private String name;

    @NotBlank
    @Size(min = 1, max = 255, message = "description should be between 1 to 255 characters")
    private String description;

}
