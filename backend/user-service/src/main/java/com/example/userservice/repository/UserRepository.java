package com.example.userservice.repository;

import com.example.userservice.entities.RoleEntity;
import com.example.userservice.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByRole(RoleEntity role);
    List<UserEntity> findByRoleId(int roleId);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByLogin(String email);
}