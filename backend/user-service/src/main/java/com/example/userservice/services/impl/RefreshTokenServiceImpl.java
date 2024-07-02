package com.example.userservice.services.impl;

import com.example.userservice.entities.RefreshTokenEntity;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.exceptions.NotFoundException;
import com.example.userservice.repository.RefreshTokenRepository;
import com.example.userservice.services.RefreshTokenService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    @Autowired
    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Override
    public RefreshTokenEntity generateRefreshToken(UserEntity user) {
        RefreshTokenEntity refreshTokenEntity = new RefreshTokenEntity(user.getId(), UUID.randomUUID(),
                LocalDateTime.now(), LocalDateTime.now().plusDays(30));
        refreshTokenRepository.save(refreshTokenEntity);
        return refreshTokenEntity;
    }

    @Override
    public RefreshTokenEntity checkRefreshToken(UserEntity user, String refreshToken) {
        RefreshTokenEntity refreshTokenEntity = refreshTokenRepository.findById(user.getId())
                .orElseThrow(() -> new NotFoundException("refresh token for this user not found"));
        if (validate(refreshTokenEntity)) {
            throw new RuntimeException("refresh token has expired"); //todo custom exception
        }
        if (refreshToken.equals(refreshTokenEntity.getToken().toString())) {
            return generateRefreshToken(user);
        } else throw new RuntimeException("invalid refresh token"); //todo custom exception
    }

    private boolean validate(RefreshTokenEntity refreshToken) {
        return refreshToken.getExpirationTime().isBefore(LocalDateTime.now());
    }
}
