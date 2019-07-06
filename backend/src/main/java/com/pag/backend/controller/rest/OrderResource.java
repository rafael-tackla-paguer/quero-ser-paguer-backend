package com.pag.backend.controller.rest;

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

import com.pag.backend.domain.Order;
import com.pag.backend.model.PageModel;
import com.pag.backend.service.OrderService;

@RestController
@RequestMapping(value = "orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	@PostMapping
	public ResponseEntity<Order> save(@RequestBody Order order){
		Order createdOrder = service.save(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> update(@PathVariable(name = "id") Integer id, @RequestBody Order order){
		order.setId(id);
		Order updatedOrder = service.update(order);
		return ResponseEntity.ok(updatedOrder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable("id") Integer id) {
		Order order = service.findById(id);
		return ResponseEntity.ok(order);
	}
	
	@GetMapping
	public ResponseEntity<PageModel<Order>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		PageModel<Order> orders = service.findAll(pageable);
		
		return ResponseEntity.ok(orders);
	}
	
}
