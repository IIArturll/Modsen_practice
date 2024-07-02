package com.example.productservice.controllers;

import com.example.productservice.core.dto.IngredientDTO;
import com.example.productservice.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingredient ")
public class IngredientController {

    private IngredientService ingredientService;

    @PostMapping()
    public ResponseEntity<?> newIngredient (@RequestBody IngredientDTO ingredient ) {
        ingredientService.create(ingredient);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllIngredients() {
        return ResponseEntity.status(200).body(ingredientService.getAll());
    }

    @GetMapping("/{ingredientId}")
    public ResponseEntity<?> getIngredientById(@PathVariable("ingredientId") int ingredientId) {
        return ResponseEntity.status(200).body(ingredientService.getById(ingredientId));
    }

    @PutMapping()
    public ResponseEntity<?> updateIngredient( @RequestBody IngredientDTO ingredient ) {
        ingredientService.update(ingredient.id(), ingredient);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteIngredient(@RequestBody IngredientDTO ingredient) {
        ingredientService.delete(ingredient.id());
        return ResponseEntity.status(204).build();
    }
}
