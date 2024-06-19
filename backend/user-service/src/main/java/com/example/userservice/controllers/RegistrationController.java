package com.example.userservice.controllers;

import com.example.userservice.core.dto.UserCreateDTO;
import com.example.userservice.services.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/perform/for_customer")
    public ResponseEntity<?> registerCustomer(@RequestBody @Valid UserCreateDTO user) {
        String jwtToken = registrationService.register(user, "CUSTOMER");
        return ResponseEntity.status(201).body(jwtToken);
    }

    @PostMapping("/perform/for_admin")
    public ResponseEntity<?> registerAdmin(@RequestBody @Valid UserCreateDTO user) {
        String jwtToken = registrationService.register(user, "ADMIN");
        return ResponseEntity.status(201).body(jwtToken);
    }
}
