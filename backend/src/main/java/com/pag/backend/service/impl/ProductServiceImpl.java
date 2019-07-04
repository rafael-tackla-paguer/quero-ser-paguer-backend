package com.pag.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pag.backend.domain.Product;
import com.pag.backend.repository.ProductRepository;
import com.pag.backend.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product save(Product product) {
		return repository.save(product);
	}

	@Override
	public Product update(Product product) {
		return repository.save(product);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return repository.findById(id);
	}

}
