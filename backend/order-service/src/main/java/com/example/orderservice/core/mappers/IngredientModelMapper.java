package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.IngredientModelDTO;
import com.example.orderservice.enities.IngredientModelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientModelMapper {

    @Mapping(source = "ingredient.id", target = "ingredientId")
    IngredientModelDTO toDTO(IngredientModelEntity ingredientModelEntity);

}
