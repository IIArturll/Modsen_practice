package com.example.productservice.services.impl;

import com.example.productservice.mappers.CategoryDTOMapper;
import com.example.productservice.dto.CategoryDTO;
import com.example.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDTOMapper categoryDTOMapper;

    @Autowired
    public CategoryServiceImpl(CategoryDTOMapper categoryDTOMapper) {
        this.categoryDTOMapper = categoryDTOMapper;
    }

    @Override
    public List<CategoryDTO> getAll() {
        return List.of();
    }

    @Override
    public CategoryDTO getById(Integer id) {
        return null;
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO update(Integer id, CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
