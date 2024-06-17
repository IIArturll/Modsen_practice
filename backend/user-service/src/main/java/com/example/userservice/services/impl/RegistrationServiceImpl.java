package com.example.userservice.services.impl;

import com.example.userservice.core.dto.UserCreateDTO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.services.RegistrationService;
import com.example.userservice.services.RoleService;
import com.example.userservice.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO register(UserCreateDTO userDto) {
        if (userService.getByEmail(userDto.getEmail()) != null) {
            // throw new UserAlreadyExistsException("User already exist with email: " + userDto.getEmail());
        } else if (userService.getByLogin(userDto.getLogin()) != null) {
            // throw new UserAlreadyExistsException("User already exist with login: " + userDto.getLogin());
        }

        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getFirstname());
        user.setSurname(userDto.getLastname());
        // ток роль должна быть уникальной, по-крайней мере так в энтити
        user.setRole(roleService.save("USER"));
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // надо продумать снова дтошки - какие для чего использовать...
        return userService.save(user);
    }
}
