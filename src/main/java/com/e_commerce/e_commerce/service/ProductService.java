package com.e_commerce.e_commerce.service;

import com.e_commerce.e_commerce.dto.UpdateProductDto;
import com.e_commerce.e_commerce.entity.ProductEntity;
import com.e_commerce.e_commerce.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    // Get single product
    public ResponseEntity<ProductEntity> getSingleProduct(UUID productId) {

        return productRepository.findById(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Save product
    public ResponseEntity<ProductEntity> saveProduct(ProductEntity product) {

        ProductEntity savedProduct =
                productRepository.save(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProduct);
    }

    // Update product
    public ResponseEntity<ProductEntity> updateProduct(
            UUID productId,
            UpdateProductDto dto) {

        return productRepository.findById(productId)
                .map(product -> {

                    product.setItem(dto.item());
                    product.setDescription(dto.description());
                    product.setQuantity(dto.quantity());
                    product.setCategory(dto.category());
                    product.setPrice(dto.price());
                    product.setAvailablePieces(dto.availablePieces());
                    product.setProductImage(dto.productImage());

                    ProductEntity updated =
                            productRepository.save(product);

                    return ResponseEntity
                            .ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete product
    public ResponseEntity<Void> removeSingleProduct(
            @PathVariable
            UUID productId) {

        return productRepository.findById(productId)
                .map(product -> {
                    productRepository.delete(product);

                    return ResponseEntity
                            .noContent()
                            .<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}