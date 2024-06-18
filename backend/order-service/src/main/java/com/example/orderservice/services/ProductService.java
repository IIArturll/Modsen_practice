package com.example.orderservice.services;

import com.example.productservice.dto.ProductDTO;
import java.util.List;

public interface ProductService {

    List<ProductDTO> getAll();

    ProductDTO getById(Integer id);

    ProductDTO create(ProductDTO productDTO);

    ProductDTO update(Integer id, ProductDTO productDTO);

    void delete(Integer id);
}
