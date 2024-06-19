package com.example.productservice.core.mappers;

import com.example.productservice.core.dto.ProductDTO;
import com.example.productservice.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = IngredientModelMapper.class)
public interface ProductMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO toDto(ProductEntity productEntity);
}


