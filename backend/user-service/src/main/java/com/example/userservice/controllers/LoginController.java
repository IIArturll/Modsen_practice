package com.example.userservice.controllers;

import com.example.userservice.core.dto.UserLoginDTO;
import com.example.userservice.services.CustomerService;
import com.example.userservice.services.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/perform")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginDTO user) {
        String jwtToken = loginService.login(user);
        return ResponseEntity.status(201).body(jwtToken);
    }
}
