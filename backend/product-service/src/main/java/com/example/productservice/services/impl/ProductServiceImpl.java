package com.example.productservice.services.impl;

import com.example.productservice.mappers.ProductDTOMapper;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDTOMapper productDTOMapper;

    @Autowired
    public ProductServiceImpl(ProductDTOMapper productDTOMapper) {
        this.productDTOMapper = productDTOMapper;
    }

    @Override
    public List<ProductDTO> getAll() {
        return List.of();
    }

    @Override
    public ProductDTO getById(Integer id) {
        return null;
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO update(Integer id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
