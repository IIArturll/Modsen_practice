package com.example.userservice.controllers;

import com.example.userservice.entities.UserEntity;
import com.example.userservice.services.UserMicroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("micro/user")
public class MicroUserController {
    private final UserMicroService service;

    public MicroUserController(UserMicroService service) {
        this.service = service;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<UserEntity>> get(@PathVariable("id") Integer id) {
        return ResponseEntity.status(200).body(service.getById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<UserEntity>> getByEmail(@PathVariable("email") String email) {
        return ResponseEntity.status(200).body(service.getByEmail(email));
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<Optional<UserEntity>> getByLogin(@PathVariable("login") String login) {
        return ResponseEntity.status(200).body(service.getByLogin(login));
    }
}
