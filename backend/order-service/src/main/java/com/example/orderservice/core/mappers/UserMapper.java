package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.UserDTO;
import com.example.orderservice.enities.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper{

    UserDTO toDTO(UserEntity userEntity);
}
