package com.example.userservice.services;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.dto.UserLoginDTO;

public interface LoginService {
    String login(UserLoginDTO user);
}
