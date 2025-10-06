package com.example.resource_server.repository;

import com.example.resource_server.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("SELECT p FROM Product p WHERE p.subCategory.id IN (SELECT sc.id FROM SubCategory sc WHERE sc.category = ?1)")
    List<Product> getAllProductByCategoryId(Long categoryId);
    @Query("SELECT p FROM Product p WHERE p.subCategory.id = ?1")
    List<Product> getAllProductBySubCategoryId(Long subCategoryId);
}
