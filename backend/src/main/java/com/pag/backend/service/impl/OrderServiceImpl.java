package com.pag.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pag.backend.domain.Order;
import com.pag.backend.model.PageModel;
import com.pag.backend.repository.OrderRepository;
import com.pag.backend.service.OrderService;
import com.pag.backend.service.exception.NotFoundException;

@Service
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
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Order> findAll() {
		return repository.findAll();
	}

	@Override
	public Order findById(Integer id) {
		Optional<Order> result = repository.findById(id);
		return result.orElseThrow(()-> new NotFoundException() );
	}

	@Override
	public PageModel<Order> findAll(Pageable pageable) {
		
		Page<Order> pagedResult = repository.findAll(pageable);
		PageModel<Order> pageModel = new PageModel<Order>(pagedResult.getTotalElements(), pagedResult.getSize(), pagedResult.getTotalPages(), pagedResult.getContent());
		return pageModel;
	}

}
