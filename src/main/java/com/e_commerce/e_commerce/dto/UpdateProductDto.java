package com.e_commerce.e_commerce.dto;

public record UpdateProductDto(
        String item,
        String description,
        Integer quantity,
        String category,
        Integer price,
        Integer availablePieces,
        String productImage
) {
}
