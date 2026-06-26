package com.e_commerce.e_commerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllProducts {
    @GetMapping ("/api/v1/products")
    public String getAllProducts() {
        return "all products page";
    }
}
