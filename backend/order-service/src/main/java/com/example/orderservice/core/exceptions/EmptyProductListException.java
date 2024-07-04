package com.example.orderservice.core.exceptions;

public class EmptyProductListException extends RuntimeException {
    public EmptyProductListException(String message) {
        super(message);
    }
}