package com.e_commerce.e_commerce.controller;

import com.e_commerce.e_commerce.dto.PostProduct;
import org.springframework.web.bind.annotation.*;

@RestController
public class AllProducts {
    @GetMapping ("/api/v1/products")
    public String getAllProducts() {
        return "all products page";
    }

    @PostMapping("/api/v1/products")
    public String savedProduct(@RequestBody PostProduct post) {
        return post.productId();
    }
}
