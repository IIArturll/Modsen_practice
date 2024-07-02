package com.example.productservice.services.impl;

import com.example.productservice.entities.ProductEntity;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.services.MicroProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MicroProductServiceImpl implements MicroProductService {
    private final ProductRepository productRepository;

    public MicroProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Optional<ProductEntity> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Optional<ProductEntity>> getProductByIds(List<Integer> ids) {
        List<Optional<ProductEntity>> products = new ArrayList<>();
        for (Integer id : ids) {
            Optional<ProductEntity> optionalProduct = productRepository.findById(id);
            products.add(optionalProduct);
        }
        return products;
    }
}
