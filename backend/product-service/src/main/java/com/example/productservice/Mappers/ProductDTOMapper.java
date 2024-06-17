package com.example.productservice.Mappers;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProductDTOMapper implements Function<ProductEntity, ProductDTO> {

    private final IngredientModelDTOMapper ingredientModelDTOMapper;

    @Autowired
    public ProductDTOMapper(IngredientModelDTOMapper ingredientModelDTOMapper) {
        this.ingredientModelDTOMapper = ingredientModelDTOMapper;
    }

    @Override
    public ProductDTO apply(ProductEntity productEntity) {
        return new ProductDTO(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getWeight(),
                productEntity.getCategory().getId(),
                productEntity.getCalories(),
                productEntity.getProtein(),
                productEntity.getFats(),
                productEntity.getCarbs(),
                productEntity.getPrice(),
                productEntity.getIngredients()
                        .stream()
                        .map(ingredientModelDTOMapper)
                        .collect(Collectors.toList())
        );
    }
}

