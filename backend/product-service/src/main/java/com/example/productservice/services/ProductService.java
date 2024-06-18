package com.example.productservice.services;

import com.example.productservice.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAll();

    ProductDTO getById(Integer id);

    ProductDTO create(ProductDTO productDTO);

    ProductDTO update(Integer id, ProductDTO productDTO);

    void addIngredientToProduct(Integer productId, Integer ingredientId, Double weight);

    void removeIngredientFromProduct(Integer productId, Integer ingredientId);

    void delete(Integer id);
}
