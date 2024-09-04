package com.example.userservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "refresh_token", schema = "modsen")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RefreshTokenEntity {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "refresh_token")
    private UUID token;
    @Column(name = "update_time")
    private LocalDateTime updateTime;
    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;
}
