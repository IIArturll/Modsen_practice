package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.IngredientDTO;
import com.example.orderservice.enities.IngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientMapper {

    IngredientDTO toDTO(IngredientEntity ingredientEntity);
}
