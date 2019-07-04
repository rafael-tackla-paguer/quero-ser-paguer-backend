package com.pag.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pag.backend.domain.OrderItem;
import com.pag.backend.repository.OrderItemRepository;
import com.pag.backend.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository repository;
	
	@Override
	public OrderItem save(OrderItem orderItem) {
		return repository.save(orderItem);
	}

	@Override
	public Optional<OrderItem> update(Long id, OrderItem orderItem) {
		return repository.findById(id).map(mapper -> {
			mapper.setAmount(orderItem.getAmount());
			mapper.setPrice(orderItem.getPrice());
			return repository.save(mapper);
		});
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<OrderItem> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<OrderItem> findById(Long id) {
		return repository.findById(id);
	}

}
