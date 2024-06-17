package com.example.userservice.services.impl;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.dto.UserLoginDTO;
import com.example.userservice.services.LoginService;
import com.example.userservice.services.UserService;

public class LoginServiceImpl implements LoginService {
    private final UserService userService;
    private final String emailValidationPattern = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    private final String loginValidationPattern =  "^[a-zA-Z]+$";

    public LoginServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO login(UserLoginDTO user) {
        String userIdentifier = user.getIdentifier();
        if (userIdentifier.matches(emailValidationPattern)) {
            return  userService.getByEmail(userIdentifier);
        } else if (userIdentifier.matches(loginValidationPattern)) {
            return userService.getByLogin(userIdentifier);
        } else {
//            throw new UserNotFoundException;
            return null;
        }
    }
}
