package com.example.userservice.core.dto;

import com.example.userservice.entities.Sex;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public class UserDTO {
    private UUID id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
            message = "illegal format of email,correct example: email@mail.ru , google@gmail.com")
    private String email;

    @NotNull
    @NotBlank
    private String firstname;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    private Sex sex;

    public UserDTO() {
    }

    public UserDTO(UUID id, String email, String firstname, String lastname, Sex sex) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
    }

    public UserDTO(String email, String firstname, String lastname, Sex sex) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
