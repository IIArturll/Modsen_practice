package com.example.userservice.services;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.entities.RoleEntity;

import java.util.List;

public interface RoleService {
    RoleEntity save(String role);

    RoleEntity update(Integer id, String role);

    void delete(Integer id);

    RoleEntity getById(Integer id);

    RoleEntity getByRole(String role);

    Iterable<RoleEntity> getAll();
}
