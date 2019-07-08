package com.pag.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pag.backend.domain.OrderItem;
import com.pag.backend.model.PageModel;
import com.pag.backend.repository.OrderItemRepository;
import com.pag.backend.service.OrderItemService;
import com.pag.backend.service.exception.NotFoundException;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository repository;
	
	@Override
	public OrderItem save(OrderItem orderItem) {
		return repository.save(orderItem);
	}

	@Override
	public OrderItem update(OrderItem orderItem) {
		return repository.save(orderItem);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<OrderItem> findAll() {
		return repository.findAll();
	}

	@Override
	public OrderItem findById(Integer id) {
		Optional<OrderItem> result = repository.findById(id);
		return result.orElseThrow(()-> new NotFoundException());
	}

	@Override
	public PageModel<OrderItem> findAll(Pageable pageable) {
		
		Page<OrderItem> pagedResult = repository.findAll(pageable);
		PageModel<OrderItem> pageModel= new PageModel<OrderItem>(pagedResult.getTotalElements(), pagedResult.getSize(), pagedResult.getTotalPages(), pagedResult.getContent());
		return pageModel;
	}

	@Override
	public List<OrderItem> findAllByOrderId(Integer orderId) {
		return repository.findAllByOrderId(orderId);
	}

}
