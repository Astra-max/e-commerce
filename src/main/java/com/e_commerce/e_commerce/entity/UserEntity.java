package com.e_commerce.e_commerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID userId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String secondName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
