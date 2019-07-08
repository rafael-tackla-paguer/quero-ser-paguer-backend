package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.OrderItem;
import com.pag.backend.model.PageModel;

public interface OrderItemService {

	OrderItem save (OrderItem orderItem);
	
	OrderItem update(OrderItem orderItem);
	
	void delete(Integer id);
	
	List<OrderItem> findAll();
	
	OrderItem findById(Integer id);

	PageModel<OrderItem> findAll(Pageable pageable);

	List<OrderItem> findAllByOrderId(Integer orderId);
}
