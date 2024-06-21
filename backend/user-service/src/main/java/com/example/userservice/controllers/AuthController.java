package com.example.userservice.controllers;

import com.example.userservice.entities.User;
import com.example.userservice.payload.request.LoginRequest;
import com.example.userservice.payload.request.SignupRequest;
import com.example.userservice.payload.request.TokenRefreshRequest;
import com.example.userservice.payload.response.JwtResponse;
import com.example.userservice.payload.response.MessageResponse;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.security.JwtUtils;
import com.example.userservice.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String refreshToken = jwtUtils.generateRefreshToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        if (jwtUtils.validateJwtToken(requestRefreshToken)) {
            String username = jwtUtils.getUsernameFromJwtToken(requestRefreshToken);
            UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
            String newToken = jwtUtils.generateJwtToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(newToken, requestRefreshToken, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail()));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Invalid refresh token"));
        }
    }
}