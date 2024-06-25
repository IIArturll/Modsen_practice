package com.example.orderservice.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductsNotFoundException extends RuntimeException {
    private final String message = "Products with this ids not found";
    private List<Integer> productIds = new ArrayList<>();

    public void addProductId(Integer productId) {
        this.productIds.add(productId);
    }
}
