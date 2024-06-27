package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.OrderDTO;
import com.example.orderservice.enities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
uses = {ProductMapper.class})
public interface OrderMapper {

    @Mapping(source = "user.id", target = "userId")
    OrderDTO toDTO(OrderEntity products);

}