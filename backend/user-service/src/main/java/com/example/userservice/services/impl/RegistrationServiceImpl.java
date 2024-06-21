package com.example.userservice.services.impl;

import com.example.userservice.core.dto.UserCreateDTO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.entities.RoleEntity;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.exceptions.UserAlreadyExistsException;
import com.example.userservice.services.RegistrationService;
import com.example.userservice.services.RoleService;
import com.example.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.relation.Role;

@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(UserCreateDTO userDto, String role) {
        if (userService.getByEmail(userDto.getEmail()) != null) {
            throw new UserAlreadyExistsException("User already exist with email: " + userDto.getEmail());
        } else if (userService.getByLogin(userDto.getLogin()) != null) {
            throw new UserAlreadyExistsException("User already exist with login: " + userDto.getLogin());
        }

        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setName(userDto.getFirstname());
        user.setSurname(userDto.getLastname());
        user.setRole(roleService.save(role));
        user.setDateOfBirth(userDto.getDateOfBirth());

        userService.save(user);
        
        String jwtToken = tokenUtil.generateToken(user);
        return jwtToken;
    }
}
