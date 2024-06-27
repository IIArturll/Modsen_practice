package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.ProductDTO;
import com.example.orderservice.enities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO toDTO(ProductEntity productEntity);
}


