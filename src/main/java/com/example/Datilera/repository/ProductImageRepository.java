package com.example.datilera.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.datilera.domain.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long>{

}