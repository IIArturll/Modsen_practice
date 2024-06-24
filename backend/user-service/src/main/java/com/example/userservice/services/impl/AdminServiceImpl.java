package com.example.userservice.services.impl;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.enums.Role;
import com.example.userservice.core.mappers.UserMapper;
import com.example.userservice.entities.RoleEntity;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.exceptions.BadRequestException;
import com.example.userservice.exceptions.NotFoundException;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.services.AdminService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final String emailValidationPattern = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    private final String loginValidationPattern = "^[a-zA-Z]+$";
    private final UserMapper userMapper;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void updateRoleForUser(Integer id, Role role) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User with id " + id + " not found"));
        userEntity.setRole(new RoleEntity(role));
        userRepository.save(userEntity);
    }

    @Override
    public UserDTO updateUserData(Integer id, UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User with id " + id + " not found"));
        //todo verify new email if email was changed
        UserEntity entity = userMapper.toEntity(userDTO);
        UserEntity savedUser = userRepository.save(entity);
        return userMapper.toDto(savedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User with id " + id + " not found"));
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User with id " + id + " not found"));
        return userMapper.toDto(userEntity);
    }

    @Override
    public UserDTO getUserByLoginOrEmail(String identifier) {
        UserEntity entity;
        if (identifier.matches(emailValidationPattern)) {
            entity = userRepository.findByEmail(identifier).orElseThrow(
                    () -> new NotFoundException("user with email: " + identifier + " not found"));
        } else if (identifier.matches(loginValidationPattern)) {
            entity = userRepository.findByLogin(identifier).orElseThrow(
                    () -> new NotFoundException("user with login: " + identifier + " not found"));
        } else {
            throw new BadRequestException("incorrect format of login/email");
        }
        return userMapper.toDto(entity);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }


}
