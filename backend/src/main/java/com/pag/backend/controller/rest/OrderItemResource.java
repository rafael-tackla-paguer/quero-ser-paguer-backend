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

import com.pag.backend.domain.OrderItem;
import com.pag.backend.model.PageModel;
import com.pag.backend.service.OrderItemService;

/**
 * Classe de controller responsável pelo recurso {@link OrderItem}
 * @author rafael.tackla
 *
 */
@RestController
@RequestMapping(value = "order-items")
public class OrderItemResource {
	
	@Autowired
	private OrderItemService service;
	
	@PostMapping
	public ResponseEntity<OrderItem> save(@RequestBody @Valid OrderItem orderItem){
		OrderItem createdOrderItem = service.save(orderItem);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItem);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrderItem> update(@PathVariable(name = "id") Integer id, @RequestBody @Valid OrderItem orderItem){
		orderItem.setId(id);
		OrderItem updatedOrderItem = service.update(orderItem);
		return ResponseEntity.ok(updatedOrderItem);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderItem> findById(@PathVariable("id") Integer id) {
		OrderItem orderItem = service.findById(id);
		return ResponseEntity.ok(orderItem);
	}
	
	@GetMapping
	public ResponseEntity<PageModel<OrderItem>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		PageModel<OrderItem> orderItems = service.findAll(pageable);
		
		return ResponseEntity.ok(orderItems);
	}
}
