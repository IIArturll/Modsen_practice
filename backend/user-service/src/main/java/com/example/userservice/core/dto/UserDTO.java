package com.example.userservice.core.dto;

import com.example.userservice.core.enums.Role;
import com.example.userservice.core.enums.Sex;
import com.example.userservice.core.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserDTO(
        Integer id,

        @NotNull
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
                message = "illegal format of email,correct example: email@mail.ru , google@gmail.com")
        String email,
        @NotNull
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z]+$",
                message = "illegal format of login")
        String login,

        @NotNull
        @NotBlank
        String name,

        @NotNull
        @NotBlank
        String surname,

        @NotNull
        Sex sex,

        @NotNull
        Role role,

        @NotNull
        Status status
) {
}
