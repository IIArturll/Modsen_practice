package com.example.userservice.services;

import com.example.userservice.core.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO update(UUID id, UserDTO userDto);

    void delete(UUID id);

    UserDTO getById(UUID id);

    List<UserDTO> getAll();
}
