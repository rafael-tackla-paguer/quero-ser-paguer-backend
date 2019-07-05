package com.pag.backend.service;

import java.util.List;

import com.pag.backend.domain.OrderItem;

public interface OrderItemService {

	OrderItem save (OrderItem orderItem);
	
	OrderItem update(OrderItem orderItem);
	
	void delete(Integer id);
	
	List<OrderItem> findAll();
	
	OrderItem findById(Integer id);
}
