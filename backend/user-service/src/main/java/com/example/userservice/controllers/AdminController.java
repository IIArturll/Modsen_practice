package com.example.userservice.controllers;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.core.enums.Role;
import com.example.userservice.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PutMapping("/update/{userId}/{role}")
    public ResponseEntity<?> updateUserRole(@PathVariable Integer userId, @PathVariable String role) {
        Role roleEnum = Role.valueOf(role.toUpperCase());
        adminService.updateRoleForUser(userId, roleEnum);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDTO> updateUserData(@PathVariable Integer userId,
                                                  @RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.status(200).body(adminService.updateUserData(userId, userDTO));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        adminService.deleteUser(userId);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/id/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(adminService.getUserById(userId));
    }

    @GetMapping("/identifier/{identifier}")
    public ResponseEntity<UserDTO> getUserByIdentifier(@PathVariable String identifier) {
        return ResponseEntity.status(200).body(adminService.getUserByLoginOrEmail(identifier));
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.status(200).body(adminService.getAllUsers());
    }
}
