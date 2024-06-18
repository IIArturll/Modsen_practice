package com.example.orderservice.mappers;

import com.example.orderservice.dto.ProductDTO;
import com.example.orderservice.enities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProductMapper implements Function<ProductEntity, ProductDTO> {

    private final IngredientModelMapper ingredientModelDTOMapper;

    @Autowired
    public ProductMapper(IngredientModelMapper ingredientModelDTOMapper) {
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

