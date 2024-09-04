package com.example.userservice.controllers;

import com.example.userservice.core.dto.UserCreateDTO;
import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.dto.UserLoginDTO;
import com.example.userservice.core.dto.AuthDTO;
import com.example.userservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDTO> login(@RequestBody @Valid UserLoginDTO user) {
        return ResponseEntity.status(201).body(userService.login(user));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserCreateDTO user) {
        userService.register(user);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthDTO> refreshTokens(@RequestBody @Valid AuthDTO authDTO) {
        return ResponseEntity.status(200).body(userService.refreshToken(authDTO));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid UserCreateDTO user) {
        userService.update(user);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete() {
        userService.delete();
        return ResponseEntity.status(204).build();
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUserInfo() {
        return ResponseEntity.status(200).body(userService.getUserInfo());
    }
}
