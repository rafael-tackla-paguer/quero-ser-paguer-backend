package com.pag.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pag.backend.domain.Order;
import com.pag.backend.repository.OrderRepository;
import com.pag.backend.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Override
	public Order save(Order order) {
		return repository.save(order);
	}

	@Override
	public Order update(Order order) {
		return repository.save(order);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Order> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Order> findById(Long id) {
		return repository.findById(id);
	}

}
