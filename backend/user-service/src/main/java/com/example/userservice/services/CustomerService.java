package com.example.userservice.services;

import com.example.userservice.core.dto.UserDTO;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    UserDTO update(UUID id, UserDTO userDto);

    void delete(UUID id);

    UserDTO getById(UUID id);

    Iterable<User> getAll();
}
