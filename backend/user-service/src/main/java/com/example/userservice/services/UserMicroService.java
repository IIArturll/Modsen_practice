package com.example.userservice.services;

import com.example.userservice.entities.UserEntity;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserMicroService {
    Optional<UserEntity> getById(Integer id);

    Optional<UserEntity> getByEmail(String email);

    Optional<UserEntity> getByLogin(String login);
}
