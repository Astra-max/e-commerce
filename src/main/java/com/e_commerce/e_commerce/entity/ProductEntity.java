package com.e_commerce.e_commerce.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

import java.util.UUID;

@Data
@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID productId;

    @Column(nullable = false)
    private String item;

    @Column(nullable = false, length = 300)
    private String description;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer availablePieces;

    @Column(nullable = false)
    private String productImage;
}
