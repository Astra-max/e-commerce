package com.e_commerce.e_commerce.dto;

// define and returns errors and status code
public record ErrorResponse(
        String message,
        int statusCode
) {
}
