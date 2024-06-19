package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.ProductDTO;
import com.example.orderservice.enities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = IngredientModelMapper.class)
public interface ProductMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO toDTO(ProductEntity productEntity);
}


