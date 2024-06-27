package com.example.userservice.services;

import com.example.userservice.core.dto.UserCreateDTO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.dto.UserLoginDTO;
import com.example.userservice.core.dto.AuthDTO;

public interface UserService {

    void register(UserCreateDTO userDTO);

    AuthDTO login(UserLoginDTO userDTO);

    AuthDTO refreshToken(AuthDTO authDTO);

    void update(UserCreateDTO userDto);

    void delete();

    UserDTO getUserInfo();
}

