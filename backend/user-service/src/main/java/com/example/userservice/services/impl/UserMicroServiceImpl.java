package com.example.userservice.services.impl;

import com.example.userservice.entities.UserEntity;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.services.UserMicroService;

import java.util.Optional;

public class UserMicroServiceImpl implements UserMicroService {

    private final UserRepository repository;

    public UserMicroServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UserEntity> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        return repository.findByEmail(email);
    }
}
