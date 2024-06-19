package com.example.productservice.core.mappers;

import com.example.productservice.core.dto.IngredientModelDTO;
import com.example.productservice.entities.IngredientModelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientModelMapper {
    IngredientModelDTO toDTO(IngredientModelEntity ingredientModelEntity);
}

