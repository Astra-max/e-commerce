package com.e_commerce.e_commerce.controller;

import com.e_commerce.e_commerce.dto.PostProduct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Products {
    private final List<PostProduct> products = new ArrayList<PostProduct>();

    @GetMapping ("/api/v1/products")
    public List<PostProduct> getAllProducts() {
        return products;
    }

    @PostMapping("/api/v1/products")
    public PostProduct savedProduct(@RequestBody PostProduct post) {
        products.add(post);
        return post;
    }
    @GetMapping ("/api/v1/products/{productId}")
    public PostProduct singleProduct(@PathVariable String productId) {
        return products.get(0);
    }
}
