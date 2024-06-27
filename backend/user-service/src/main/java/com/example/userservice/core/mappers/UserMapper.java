package com.example.userservice.core.mappers;

import com.example.userservice.core.dto.UserDTO;
import com.example.userservice.entities.UserEntity;
import com.example.userservice.security.MyUserDetails;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(source = "role.role", target = "role")
    @Mapping(source = "status.status", target = "status")
    UserDTO toDto(UserEntity userEntity);

    @Mapping(source = "role", target = "role.role")
    @Mapping(source = "status", target = "status.status")
    UserEntity toEntity(UserDTO userDTO);

    @Mapping(source = "role.role", target = "role")
    @Mapping(source = "status.status", target = "status")
    MyUserDetails userEntityToMyUserDetails(UserEntity userEntity);

}