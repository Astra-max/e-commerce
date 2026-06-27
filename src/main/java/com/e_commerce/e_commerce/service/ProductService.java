package com.e_commerce.e_commerce.service;

import com.e_commerce.e_commerce.dto.UpdateProductDto;
import com.e_commerce.e_commerce.entity.ProductEntity;
import com.e_commerce.e_commerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // get all products from database
    public List<ProductEntity> getAllProducts()  {
        return productRepository.findAll();
    }

    // get single product
    public ProductEntity getSingleProduct(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("product not found"));
    }

    // add new product to database
    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    // update single product in database
    public ProductEntity updateProduct(UUID productId, UpdateProductDto dto) {
        ProductEntity product = getSingleProduct(productId);

        product.setItem(dto.item());
        product.setDescription(dto.description());
        product.setQuantity(dto.quantity());
        product.setCategory(dto.category());
        product.setPrice(dto.price());
        product.setAvailablePieces(dto.availablePieces());
        product.setProductImage(dto.productImage());

        return productRepository.save(product);
    }

    // remove single product from database
    public void removeSingleProduct(UUID productId) {
        productRepository.deleteById(productId);
    }
}
