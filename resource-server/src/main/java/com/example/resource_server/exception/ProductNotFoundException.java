package com.example.resource_server.exception;

import jakarta.annotation.Nullable;

import java.util.Optional;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(@Nullable String message){
        super(Optional.ofNullable(message).orElse("Product Not Found"));
    }
}
