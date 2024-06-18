package com.example.productservice.core.mappers;

import com.example.productservice.core.dto.CategoryDTO;
import com.example.productservice.entities.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoryMapper implements Function<CategoryEntity, CategoryDTO> {

    @Override
    public CategoryDTO apply(CategoryEntity categoryEntity) {
        return new CategoryDTO(
                categoryEntity.getId(),
                categoryEntity.getName(),
                categoryEntity.getDescription()
                );
    }
}
