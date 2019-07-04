package com.pag.backend.service;

import java.util.List;
import java.util.Optional;

import com.pag.backend.domain.Order;

public interface OrderService {
	
	Order save (Order order);
	
	Order update(Order order);
	
	void delete(Long id);
	
	List<Order> findAll();
	
	Optional<Order> findById(Long id);
}
