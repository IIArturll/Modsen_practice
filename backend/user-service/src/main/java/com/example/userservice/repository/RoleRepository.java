package com.example.userservice.repository;

import com.example.userservice.entities.RoleEntity;
import com.example.userservice.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByRoleUserId (int userId);

    Optional<RoleEntity> findByRoleUser (UserEntity user);

}
