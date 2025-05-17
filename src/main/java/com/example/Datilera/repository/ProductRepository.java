package com.example.Datilera.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Datilera.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
