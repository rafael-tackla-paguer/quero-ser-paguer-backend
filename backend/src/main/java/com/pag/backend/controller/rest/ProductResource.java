package com.pag.backend.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pag.backend.domain.Product;
import com.pag.backend.service.ProductService;

@RestController
@RequestMapping(value = "products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product){
		Product createdProduct = service.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable(name = "id") Long id, @RequestBody Product product){
		product.setId(id);
		Product updatedProduct = service.update(product);
		return ResponseEntity.ok(updatedProduct);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
		Product product = service.findById(id);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> customers = service.findAll();
		return ResponseEntity.ok(customers);
	}
	
}
