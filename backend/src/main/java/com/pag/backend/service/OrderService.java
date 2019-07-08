package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.Order;
import com.pag.backend.model.PageModel;

public interface OrderService {
	
	Order save (Order order);
	
	Order update(Order order);
	
	void delete(Integer id);
	
	List<Order> findAll();
	
	Order findById(Integer id);

	PageModel<Order> findAll(Pageable pageable);
	
	PageModel<Order> findAllByCustomerId(Integer id, Pageable pageable);
}
