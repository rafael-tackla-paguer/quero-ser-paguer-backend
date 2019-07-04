package com.pag.backend.service;

import java.util.List;
import java.util.Optional;

import com.pag.backend.domain.Product;

public interface ProductService {

	Product save (Product product);
	
	Optional<Product> update(Long id, Product product);
	
	void delete(Long id);
	
	List<Product> findAll();
	
	Optional<Product> findById(Long id);
	
}
