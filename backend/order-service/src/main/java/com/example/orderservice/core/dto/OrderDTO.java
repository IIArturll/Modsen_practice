package com.example.orderservice.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Integer id;

    private Integer userId;

    private Double price;

    private Integer cookingTime;

    private LocalDateTime orderTime;

    private List<ProductDTO> productsDto;
}
