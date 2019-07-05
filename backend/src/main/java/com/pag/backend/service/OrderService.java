package com.pag.backend.service;

import java.util.List;

import com.pag.backend.domain.Order;

public interface OrderService {
	
	Order save (Order order);
	
	Order update(Order order);
	
	void delete(Integer id);
	
	List<Order> findAll();
	
	Order findById(Integer id);
}
