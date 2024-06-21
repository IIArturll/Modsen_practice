package com.example.userservice.payload.request;

import javax.validation.constraints.NotBlank;

public class TokenRefreshRequest {
    @NotBlank
    private String refreshToken;

    // Getters and Setters
}
