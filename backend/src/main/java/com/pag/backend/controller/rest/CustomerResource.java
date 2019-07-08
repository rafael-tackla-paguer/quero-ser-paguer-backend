package com.pag.backend.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pag.backend.domain.Customer;
import com.pag.backend.domain.Order;
import com.pag.backend.model.PageModel;
import com.pag.backend.service.CustomerService;
import com.pag.backend.service.OrderService;

@RestController
@RequestMapping(value = "customers")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody @Valid Customer customer){
		if (customer.getId()!=null)
			throw new RuntimeException("Para criação de cliente, não deve se passar o \"id\"");
				
		Customer createdCustomer = service.save(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> update(@PathVariable(name = "id") Integer id, @RequestBody Customer customer){
		customer.setId(id);
		Customer updatedCustomer = service.update(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<PageModel<Customer>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		PageModel<Customer> customers = service.findAll(pageable);
		
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> findById(@PathVariable("id") Integer id) {
		Customer customer = service.findById(id);
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping("/{id}/orders")
	public ResponseEntity<PageModel<Order>> findAllOrdersByCustomer(@PathVariable(name = "id") Integer id, @RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		PageModel<Order> orders = orderService.findAllByCustomerId(id, pageable);
		
		return ResponseEntity.ok(orders);
	}
}
