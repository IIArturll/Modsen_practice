package com.example.productservice.services;

import com.example.productservice.core.dto.ProductCreateUpdateDTO;
import com.example.productservice.core.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAll();

    ProductDTO getById(Integer id);

    ProductDTO create(ProductCreateUpdateDTO productDTO);

    ProductDTO update(ProductCreateUpdateDTO productDTO);

    void addIngredientToProduct(Integer productId, Integer ingredientId, Integer weight);

    void removeIngredientFromProduct(Integer productId, Integer ingredientId);

    void delete(Integer id);

    List<ProductDTO> getProductsByCategory(String categoryId);
}
