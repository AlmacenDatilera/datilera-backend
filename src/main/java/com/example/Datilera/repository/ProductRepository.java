package com.example.datilera.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.datilera.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
