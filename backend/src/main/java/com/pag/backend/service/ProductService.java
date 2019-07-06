package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.Product;
import com.pag.backend.model.PageModel;

public interface ProductService {

	Product save (Product product);
	
	Product update(Product product);
	
	void delete(Integer id);
	
	List<Product> findAll();
	
	Product findById(Integer id);
	
	PageModel<Product> findAll(Pageable pageable);
}
