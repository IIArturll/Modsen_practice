package com.example.productservice.core.mappers;

import com.example.productservice.entities.UserEntity;
import com.example.productservice.security.MyUserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "role.role", target = "role")
    @Mapping(source = "status.status", target = "status")
    MyUserDetails userEntityToMyUserDetails(UserEntity userEntity);

}