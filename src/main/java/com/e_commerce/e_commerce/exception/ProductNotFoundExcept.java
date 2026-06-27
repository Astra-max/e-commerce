package com.e_commerce.e_commerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundExcept extends RuntimeException {
    public ProductNotFoundExcept(String message) {
        super(message);
    }
}
