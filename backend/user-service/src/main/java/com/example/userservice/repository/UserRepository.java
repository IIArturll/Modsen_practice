package com.example.userservice.repository;

import com.example.userservice.entities.RoleEntity;
import com.example.userservice.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByRole(RoleEntity role);

    List<UserEntity> findByRoleId(int roleId);
}
