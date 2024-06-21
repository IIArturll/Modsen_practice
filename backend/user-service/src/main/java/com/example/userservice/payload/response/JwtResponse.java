package com.example.userservice.payload.response;

public class JwtResponse {
    private String token;
    private String refreshToken;
    private Long id;
    private String username;
    private String email;

    public JwtResponse(String token, String refreshToken, Long id, String username, String email) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Getters and Setters
}
