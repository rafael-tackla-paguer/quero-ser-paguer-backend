package com.pag.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pag.backend.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
