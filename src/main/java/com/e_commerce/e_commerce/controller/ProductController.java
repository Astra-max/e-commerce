package com.e_commerce.e_commerce.controller;

import com.e_commerce.e_commerce.dto.UpdateProductDto;
import com.e_commerce.e_commerce.entity.ProductEntity;
import com.e_commerce.e_commerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductEntity> getSingleProduct(
            @PathVariable UUID productId) {

        return productService
                .getSingleProduct(productId);
    }

    @PostMapping
    public ResponseEntity<ProductEntity> savedProduct(
            @RequestBody ProductEntity product) {

        return productService
                .saveProduct(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductEntity> updateProduct(
            @PathVariable UUID productId,
            @RequestBody UpdateProductDto product) {

        return productService
                .updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable UUID productId) {

        return productService
                .removeSingleProduct(productId);
    }
}