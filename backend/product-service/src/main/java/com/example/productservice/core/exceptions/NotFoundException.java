package com.example.productservice.core.exceptions;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}