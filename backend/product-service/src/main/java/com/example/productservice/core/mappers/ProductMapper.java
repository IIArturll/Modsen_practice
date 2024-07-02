package com.example.productservice.core.mappers;

import com.example.productservice.core.dto.ProductCreateUpdateDTO;
import com.example.productservice.core.dto.ProductDTO;
import com.example.productservice.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {IngredientMapper.class, IngredientModelMapper.class,CategoryMapper.class})
public interface ProductMapper {
    ProductDTO toDto(ProductEntity productEntity);

    ProductEntity toEntity(ProductCreateUpdateDTO productDTO);
}


