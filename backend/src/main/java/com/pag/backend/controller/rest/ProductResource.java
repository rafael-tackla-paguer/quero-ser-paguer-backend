package com.pag.backend.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pag.backend.domain.Product;
import com.pag.backend.model.PageModel;
import com.pag.backend.service.ProductService;

@RestController
@RequestMapping(value = "products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody @Valid Product product){
		if (product.getId()!=null)
			throw new RuntimeException("For creation, you must not pass an id");
		
		Product createdProduct = service.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable(name = "id") Integer id, @RequestBody @Valid Product product){
		product.setId(id);
		Product updatedProduct = service.update(product);
		return ResponseEntity.ok(updatedProduct);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") Integer id) {
		Product product = service.findById(id);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping
	public ResponseEntity<PageModel<Product>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		PageModel<Product> products = service.findAll(pageable);
		
		return ResponseEntity.ok(products);
	}
	
}
