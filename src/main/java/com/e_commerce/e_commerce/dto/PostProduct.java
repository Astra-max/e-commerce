package com.e_commerce.e_commerce.dto;

public record PostProduct(
        String productId,
        String item,
        int price,
        int quantity
) {
}
