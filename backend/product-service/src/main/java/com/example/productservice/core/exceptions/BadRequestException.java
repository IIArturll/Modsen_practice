package com.example.productservice.core.exceptions;


public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}