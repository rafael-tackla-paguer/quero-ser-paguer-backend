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

import com.pag.backend.domain.Customer;
import com.pag.backend.domain.Order;
import com.pag.backend.service.CustomerService;

@RestController
@RequestMapping(value = "customers")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody Customer customer){
		Customer createdCustomer = service.save(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> update(@PathVariable(name = "id") Long id, @RequestBody Customer customer){
		customer.setId(id);
		Customer updatedCustomer = service.update(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
		Customer customer = service.findById(id);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll(){
		List<Customer> customers = service.findAll();
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/{id}/orders")
	public ResponseEntity<List<Order>> findAllOrdersByCustomer(@PathVariable(name = "id") Long id){
		return null;
	}
}
