package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.RoleDTO;
import com.example.orderservice.core.dto.UserDTO;
import com.example.orderservice.enities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper implements Function<UserEntity, UserDTO> {

    @Override
    public UserDTO apply(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getSurname(),
                userEntity.getEmail(),
                userEntity.getRole() != null ? new RoleDTO(userEntity.getRole().getId(), userEntity.getRole().getRole()) : null,
                userEntity.getSex()
        );
    }
}
