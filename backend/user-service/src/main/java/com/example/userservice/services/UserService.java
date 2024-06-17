package com.example.userservice.services;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.entities.UserEntity;

import java.util.List;

public interface UserService {

    UserDTO save(UserEntity userEntity);

    UserDTO update(Integer id, UserDTO userDto);

    void delete(Integer id);

    UserDTO getById(Integer id);

    UserDTO getByLogin(String login);

    UserDTO getByEmail(String email);

    List<UserDTO> getAll();
}
