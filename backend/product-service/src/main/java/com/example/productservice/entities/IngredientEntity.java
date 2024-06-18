package com.example.productservice.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "modsen", name = "ingredient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer calories;
    private Integer protein;
    private Integer fats;
    private Integer carbs;
}