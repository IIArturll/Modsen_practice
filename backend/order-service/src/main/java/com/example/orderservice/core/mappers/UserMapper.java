package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.UserDTO;
import com.example.orderservice.enities.UserEntity;
import com.example.orderservice.security.MyUserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDTO toDTO(UserEntity userEntity);

    @Mapping(source = "role.role", target = "role")
    @Mapping(source = "status.status", target = "status")
    MyUserDetails userEntityToMyUserDetails(UserEntity userEntity);
}
