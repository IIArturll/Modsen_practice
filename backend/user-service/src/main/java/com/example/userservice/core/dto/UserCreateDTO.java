package com.example.userservice.core.dto;

import com.example.userservice.core.enums.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


import java.sql.Date;

public record UserCreateDTO(
        @NotNull
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
                message = "illegal format of email,correct example: email@mail.ru , google@gmail.com")
        String email,

        @NotNull
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z]+$",
                message = "illegal format of email,correct example: PiZzAeNjOyEr , peperoniLover")

        @NotNull
        @NotBlank
        String login,

        @NotNull
        @NotBlank
        String password,

        @NotNull
        @NotBlank
        String name,

        @NotNull
        @NotBlank
        String surname,

        @NotNull
        Sex sex,

        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        Date dateOfBirth
) {
}
