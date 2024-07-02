package com.example.productservice.services.impl;

import com.example.productservice.core.exceptions.NotFoundException;
import com.example.productservice.core.mappers.CategoryMapper;
import com.example.productservice.core.dto.CategoryDTO;
import com.example.productservice.entities.CategoryEntity;
import com.example.productservice.repository.CategoryRepository;
import com.example.productservice.services.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper,
                               CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categoriesEntity = (List<CategoryEntity>) categoryRepository.findAll();
        return categoriesEntity.stream().map(categoryMapper::toDTO).toList();
    }

    @Override
    public CategoryDTO getById(Integer id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Category with this id not found"));
        return categoryMapper.toDTO(categoryEntity);
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryDTO);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryMapper.toDTO(categoryEntity);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        categoryRepository.findById(categoryDTO.id()).orElseThrow(
                () -> new NotFoundException("Category with this id not found"));
        categoryRepository.save(categoryMapper.toEntity(categoryDTO));
        return categoryDTO;
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Category with this id not found"));
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDTO getByName(String categoryName) {
        CategoryEntity categoryEntity = categoryRepository.findByName(categoryName).orElseThrow(
                () -> new NotFoundException("Category with this name not found"));
        return categoryMapper.toDTO(categoryEntity);
    }
}
