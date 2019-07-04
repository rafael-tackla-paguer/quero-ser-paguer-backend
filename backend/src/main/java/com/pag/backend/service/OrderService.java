package com.pag.backend.service;

import java.util.List;
import java.util.Optional;

import com.pag.backend.domain.Order;

public interface OrderService {
	
	Order save (Order order);
	
	Optional<Order> update(Long id, Order order);
	
	void delete(Long id);
	
	List<Order> findAll();
	
	Optional<Order> findById(Long id);
}
