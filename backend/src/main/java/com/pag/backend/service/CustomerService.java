package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.Customer;
import com.pag.backend.model.PageModel;

public interface CustomerService {

	Customer save (Customer customer);
	
	Customer update(Customer customer);
	
	void delete(Integer id);
	
	List<Customer> findAll();
	
	Customer findById(Integer id);

	PageModel<Customer> findAll(Pageable pageable);
	
}
