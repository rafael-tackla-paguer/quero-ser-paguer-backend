package com.pag.backend.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pag.backend.domain.Customer;
import com.pag.backend.service.CustomerService;

@RestController
@RequestMapping(value = "customers")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	@PostMapping
	public ResponseEntity<Customer> save (@RequestBody Customer customer){
		Customer createdCustomer = service.save(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> update(@PathVariable(name = "id") Long id, @RequestBody Customer customer){
		customer.setId(id);
		Customer updatedCustomer = service.update(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
}
