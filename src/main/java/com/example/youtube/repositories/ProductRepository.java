package com.example.youtube.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.youtube.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
