package com.example.orderservice.core.mappers;

import com.example.orderservice.core.dto.ProductDTO;
import com.example.orderservice.enities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProductMapper implements Function<ProductEntity, ProductDTO> {

    private final IngredientModelMapper ingredientModelMapper;

    @Autowired
    public ProductMapper(IngredientModelMapper ingredientModelMapper) {
        this.ingredientModelMapper = ingredientModelMapper;
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
                        .map(ingredientModelMapper)
                        .collect(Collectors.toList())
        );
    }
}

