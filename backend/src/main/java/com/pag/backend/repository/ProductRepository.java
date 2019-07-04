package com.pag.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pag.backend.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
