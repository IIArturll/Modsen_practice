package com.example.userservice.repository;

import com.example.userservice.entities.RoleEntity;
import com.example.userservice.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByRole (String role);
}

