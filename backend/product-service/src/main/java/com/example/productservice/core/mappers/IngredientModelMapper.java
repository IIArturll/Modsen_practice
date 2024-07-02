package com.example.productservice.core.mappers;

import com.example.productservice.core.dto.IngredientModelCreateUpdateDTO;
import com.example.productservice.core.dto.IngredientModelDTO;
import com.example.productservice.entities.IngredientModelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {IngredientMapper.class})
public interface IngredientModelMapper {
    IngredientModelDTO toDTO(IngredientModelEntity ingredientModelEntity);

    IngredientModelEntity toEntity(final IngredientModelDTO dto);
    @Mapping(source = "ingredient.id",target = "ingredientId")
    IngredientModelCreateUpdateDTO toCreateUpdateDTO(IngredientModelEntity ingredientModelEntity);
}

