package com.pag.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pag.backend.domain.Product;
import com.pag.backend.model.PageModel;
import com.pag.backend.repository.ProductRepository;
import com.pag.backend.service.ProductService;
import com.pag.backend.service.exception.NotFoundException;

@Service
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
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public Product findById(Integer id) {
		Optional<Product> result = repository.findById(id);
		return result.orElseThrow(()-> new NotFoundException());
	}

	@Override
	public PageModel<Product> findAll(Pageable pageable) {
		
		Page<Product> pagedResult = repository.findAll(pageable);
		PageModel<Product> pageModel = new PageModel<>(pagedResult.getTotalElements(),	pagedResult.getSize(), pagedResult.getTotalPages(), pagedResult.getContent());
		
		return pageModel;
	}

}
