package com.example.billingservice.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public  ProductNotFoundException(String message){
        super(message);
    }
}
