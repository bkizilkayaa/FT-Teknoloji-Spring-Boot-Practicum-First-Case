package com.example.springpracticum.first_case.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundById extends RuntimeException {
    public ProductNotFoundById(String msg) {
        super(msg);
    }
}
