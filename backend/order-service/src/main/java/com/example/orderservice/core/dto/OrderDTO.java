package com.example.orderservice.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        Integer id,

        Integer userId,

        @NotNull
        @Positive(message = "price can't be negative")
        Double price,

        @NotNull
        Integer cookingTime,

        LocalDateTime orderTime,

        List<ProductDTO> products
) {

}
