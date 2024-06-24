package com.example.userservice.services;

import com.example.userservice.entities.RefreshTokenEntity;
import com.example.userservice.entities.UserEntity;


public interface RefreshTokenService {

    RefreshTokenEntity generateRefreshToken(UserEntity user);

    RefreshTokenEntity checkRefreshToken(UserEntity user, String refreshToken);
}
