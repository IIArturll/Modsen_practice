package com.example.productservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredient_model", schema = "modsen")
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