package com.pag.backend.service;

import java.util.List;

import com.pag.backend.domain.Customer;

public interface CustomerService {

	Customer save (Customer customer);
	
	Customer update(Customer customer);
	
	void delete(Long id);
	
	List<Customer> findAll();
	
	Customer findById(Long id);
	
}
