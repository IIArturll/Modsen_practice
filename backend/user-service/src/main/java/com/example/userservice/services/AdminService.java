package com.example.userservice.services;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.enums.Role;

import java.util.List;

public interface AdminService {
    void updateRoleForUser(Integer id, Role role);

    UserDTO updateUserData(Integer id, UserDTO userDTO);

    void deleteUser(Integer id);

    UserDTO getUserById(Integer id);

    UserDTO getUserByLoginOrEmail(String identifier);

    List<UserDTO> getAllUsers();
}