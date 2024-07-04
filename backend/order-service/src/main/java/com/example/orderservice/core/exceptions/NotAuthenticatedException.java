package com.example.orderservice.core.exceptions;

public class NotAuthenticatedException extends RuntimeException {
    public NotAuthenticatedException(String message) {
        super(message);
    }
}