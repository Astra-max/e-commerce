package com.e_commerce.e_commerce.controller;

import com.e_commerce.e_commerce.dto.PostProduct;
import com.e_commerce.e_commerce.entity.ProductEntity;
import com.e_commerce.e_commerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class Products {
    private final ProductService productService;

    public Products(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ProductEntity savedProduct(@RequestBody ProductEntity post) {
        return productService.saveProduct(post);
    }
    @GetMapping ("{productId}")
    public ProductEntity singleProduct(@PathVariable UUID productId) {
        return productService.getAllProducts().stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }
}
