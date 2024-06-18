package com.example.orderservice.services.impl;

import com.example.orderservice.mappers.ProductMapper;
import com.example.orderservice.services.ProductService;
import com.example.productservice.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
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
