package com.example.userservice.services;

import com.example.userservice.core.dto.UserCreateDTO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.dto.UserLoginDTO;

public interface RegistrationService {
    UserDTO register(UserCreateDTO user);
}
