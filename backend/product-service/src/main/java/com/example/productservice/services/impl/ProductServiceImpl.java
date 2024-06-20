package com.example.productservice.services.impl;

import com.example.productservice.core.dto.*;
import com.example.productservice.core.exceptions.NotFoundException;
import com.example.productservice.core.mappers.CategoryMapper;
import com.example.productservice.core.mappers.IngredientMapper;
import com.example.productservice.core.mappers.IngredientModelMapper;
import com.example.productservice.core.mappers.ProductMapper;
import com.example.productservice.entities.IngredientEntity;
import com.example.productservice.entities.IngredientModelEntity;
import com.example.productservice.entities.ProductEntity;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.services.CategoryService;
import com.example.productservice.services.IngredientService;
import com.example.productservice.services.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final IngredientService ingredientService;
    private final IngredientMapper ingredientMapper;
    private final CategoryMapper categoryMapper;
    private final IngredientModelMapper ingredientModelMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper,
                              ProductRepository productRepository,
                              CategoryService categoryService,
                              IngredientService ingredientService,
                              IngredientMapper ingredientMapper,
                              CategoryMapper categoryMapper,
                              IngredientModelMapper ingredientModelMapper) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
        this.ingredientMapper = ingredientMapper;
        this.categoryMapper = categoryMapper;
        this.ingredientModelMapper = ingredientModelMapper;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<ProductEntity> productEntities = (List<ProductEntity>) productRepository.findAll();
        return productEntities.stream().map(productMapper::toDto).toList();
    }

    @Override
    public ProductDTO getById(Integer id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product with this id not found"));
        return productMapper.toDto(productEntity);
    }

    @Override
    public ProductDTO create(ProductCreateUpdateDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.name());
        productEntity.setPrice(productDTO.price());
        productEntity.setCategory(categoryMapper
                .toEntity(categoryService.getById(productDTO.categoryId())));
        countNutritionValueAndWeight(productDTO.ingredients(), productEntity);
        ProductEntity save = productRepository.save(productEntity);
        return productMapper.toDto(save);
    }

    @Override
    public ProductDTO update(ProductCreateUpdateDTO productDTO) {
        ProductEntity productEntity = productRepository.findById(productDTO.id()).orElseThrow(
                () -> new NotFoundException("Product with this id not found"));
        productEntity.setName(productDTO.name());
        productEntity.setPrice(productDTO.price());
        countNutritionValueAndWeight(productDTO.ingredients(), productEntity);
        return productMapper.toDto(productRepository.save(productEntity));
    }

    @Override
    public void delete(Integer id) {
        productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product with this id not found"));
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) {
        CategoryDTO categoryDTO = categoryService.getByName(category);
        List<ProductEntity> allByCategoryId = productRepository.findAllByCategoryId(categoryDTO.id());
        return allByCategoryId.stream().map(productMapper::toDto).toList();
    }


    @Override
    public void addIngredientToProduct(Integer productId, Integer ingredientId, Integer weight) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException("Product with this id not found"));
        List<IngredientModelCreateUpdateDTO> ingredientModelDTOS = productEntity.getIngredients()
                .stream().map(ingredientModelMapper::toCreateUpdateDTO).collect(Collectors.toList());
        IngredientModelCreateUpdateDTO ingredientDTO = new IngredientModelCreateUpdateDTO(null, ingredientId, weight);
        ingredientModelDTOS.add(ingredientDTO);
        countNutritionValueAndWeight(ingredientModelDTOS, productEntity);
        productRepository.save(productEntity);
    }


    @Override
    public void removeIngredientFromProduct(Integer productId, Integer ingredientId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException("Product with this id not found"));
        List<IngredientModelCreateUpdateDTO> ingredientModelDTOS = productEntity.getIngredients()
                .stream().map(ingredientModelMapper::toCreateUpdateDTO).collect(Collectors.toList());
        ingredientModelDTOS.removeIf(i -> i.ingredientId().equals(ingredientId));
        countNutritionValueAndWeight(ingredientModelDTOS, productEntity);
        productRepository.save(productEntity);
    }

    private void countNutritionValueAndWeight(List<IngredientModelCreateUpdateDTO> ingredients,
                                              ProductEntity productEntity) {
        List<IngredientModelEntity> ingredientModelEntities = ingredients.stream().map((i -> {
            IngredientModelEntity ingredientModelEntity = new IngredientModelEntity();
            ingredientModelEntity.setId(i.id());
            IngredientEntity ingredientEntity = ingredientMapper
                    .toEntity(ingredientService.getById(i.ingredientId()));
            ingredientModelEntity.setIngredient(ingredientEntity);
            ingredientModelEntity.setWeight(i.weight());
            return ingredientModelEntity;
        })).collect(Collectors.toList());
        productEntity.setIngredients(ingredientModelEntities);
        int weight = 0;
        double calories = 0;
        double fats = 0;
        double protein = 0;
        double carbs = 0;
        for (var i : ingredientModelEntities) {
            weight += i.getWeight();
            double koef = (double) i.getWeight() / 100;
            calories += koef * i.getIngredient().getCalories();
            fats += koef * i.getIngredient().getFats();
            protein += koef * i.getIngredient().getProtein();
            carbs += koef * i.getIngredient().getCarbs();
        }
        productEntity.setWeight(weight);
        productEntity.setCalories((int) Math.round(calories));
        productEntity.setFats((int) Math.round(fats));
        productEntity.setProtein((int) Math.round(protein));
        productEntity.setCarbs((int) Math.round(carbs));
    }
}
