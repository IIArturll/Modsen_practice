package com.example.productservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "ingredient_model")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IngredientModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredient;
    private Integer weight;
}