package com.example.orderservice.core.dto;

import com.example.orderservice.enities.Sex;
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
public class UserDTO {

    private Integer id;

    @NotBlank()
    @Size(min = 1, max = 255, message = "Name should be between 1 and 255 characters")
    private String name;

    @NotBlank()
    @Size(min = 1, max = 255, message = "Surname should be between 1 and 255 characters")
    private String surname;

    @NotBlank()
    @Size(min = 1, max = 255, message = "Email should be between 1 and 255 characters")
    private String email;

    private RoleDTO role;

    private Sex sex;
}
