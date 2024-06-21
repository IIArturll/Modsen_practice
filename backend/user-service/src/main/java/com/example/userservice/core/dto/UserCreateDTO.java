package com.example.userservice.core.dto;

import com.example.userservice.core.enums.Sex;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Date;

public class UserCreateDTO {
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
            message = "illegal format of email,correct example: email@mail.ru , google@gmail.com")
    private String email;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$",
            message = "illegal format of email,correct example: PiZzAeNjOyEr , peperoniLover")
    private String login;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String firstname;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    @NotBlank
    private Sex sex;

    @NotNull
    @NotBlank
    private Date dateOfBirth;

    public UserCreateDTO() {
    }

    public UserCreateDTO(String email, String login, String password, String firstname, String lastname, Sex sex, Date dateOfBirth) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
