package com.example.orderservice.core.dto;

import com.example.orderservice.enities.Sex;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record UserDTO(
        Integer id,

        @NotBlank()
        @Size(min = 1, max = 255, message = "Name should be between 1 and 255 characters")
        String name,

        @NotBlank()
        @Size(min = 1, max = 255, message = "Surname should be between 1 and 255 characters")
        String surname,

        @NotBlank()
        @Size(min = 1, max = 255, message = "Email should be between 1 and 255 characters")
        String email,

        RoleDTO role,

        Sex sex
) {


}
