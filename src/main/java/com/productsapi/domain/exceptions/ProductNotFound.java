package com.productsapi.domain.exceptions;

public class ProductNotFound extends Exception{
    public ProductNotFound(String message) {
        super(message);
    }
}
