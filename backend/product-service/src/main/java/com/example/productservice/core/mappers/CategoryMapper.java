package com.example.productservice.core.mappers;

import com.example.productservice.core.dto.CategoryDTO;
import com.example.productservice.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper  {

    CategoryDTO toDTO(CategoryEntity categoryEntity);
}
