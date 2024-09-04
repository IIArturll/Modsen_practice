package com.example.orderservice.core.exceptions;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}