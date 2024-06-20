package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.OrderDTO;
import com.example.orderservice.enities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface OrderMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "cooking_time", target = "cookingTime")
    @Mapping(source = "order_time", target = "orderTime")
    @Mapping(target = "products", source = "products")
    OrderDTO toDTO(OrderEntity orderEntity);

}