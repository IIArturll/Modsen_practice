package com.example.productservice.core.mappers;


import com.example.productservice.core.dto.IngredientDTO;
import com.example.productservice.entities.IngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientMapper {
    IngredientDTO toDTO(IngredientEntity ingredientEntity);
    IngredientEntity toEntity(IngredientDTO ingredientDTO);
}
