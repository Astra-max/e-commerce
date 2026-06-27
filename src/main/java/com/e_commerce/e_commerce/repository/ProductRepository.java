package com.e_commerce.e_commerce.repository;

import com.e_commerce.e_commerce.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


/**
 * Spring-boot data jpa provides all functions possible to
 * save, get, delete, update data in the database
 * I don't have to do it manually
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
