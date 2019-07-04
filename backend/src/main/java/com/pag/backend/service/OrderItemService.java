package com.pag.backend.service;

import java.util.List;
import java.util.Optional;

import com.pag.backend.domain.OrderItem;

public interface OrderItemService {

	OrderItem save (OrderItem orderItem);
	
	OrderItem update(OrderItem orderItem);
	
	void delete(Long id);
	
	List<OrderItem> findAll();
	
	Optional<OrderItem> findById(Long id);
}
