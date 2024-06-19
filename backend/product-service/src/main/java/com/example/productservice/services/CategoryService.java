package com.example.productservice.services;

import com.example.productservice.core.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAll();

    CategoryDTO getById(Integer id);

    CategoryDTO create(CategoryDTO categoryDTO);

    CategoryDTO update(CategoryDTO categoryDTO);

    void delete(Integer id);
}
