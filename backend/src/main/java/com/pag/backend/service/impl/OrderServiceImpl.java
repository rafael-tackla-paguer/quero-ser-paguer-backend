package com.pag.backend.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pag.backend.domain.Order;
import com.pag.backend.domain.OrderItem;
import com.pag.backend.model.PageModel;
import com.pag.backend.repository.OrderRepository;
import com.pag.backend.service.OrderItemService;
import com.pag.backend.service.OrderService;
import com.pag.backend.service.exception.NotFoundException;

/**
 * @author rafael.tackla
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Override
	@Transactional
	public Order save(Order order) {
		order.setValue(calcValueOrder(order.getOrderItems()));
		Order savedOrder = repository.save(order);
		updateOrderItems(order);
		return savedOrder;
	}

	private void updateOrderItems(Order order) {
		List<OrderItem> orderItems = orderItemService.findAllByOrderId(order.getId());
		order.getOrderItems().stream().forEach( orderItem->{orderItem.setOrder(order); orderItemService.save(orderItem);});
		orderItems.removeAll(order.getOrderItems());
		orderItems.stream().forEach(orderItem->{orderItemService.delete(orderItem.getId());});
	}

	private BigDecimal calcValueOrder(List<OrderItem> orderItems) {
		double summedValue = orderItems.stream()
				.map(item -> item.getPrice().multiply(item.getAmount()))
				.mapToDouble(BigDecimal::doubleValue).sum();
		return new BigDecimal(summedValue);
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

	@Override
	public PageModel<Order> findAllByCustomerId(Integer customerId, Pageable pageable) {
		Page<Order> pagedResult = repository.findAllByCustomerId(customerId, pageable);
		PageModel<Order> pageModel= new PageModel<Order>(pagedResult.getTotalElements(), pagedResult.getSize(), pagedResult.getTotalPages(), pagedResult.getContent());
		return pageModel;
	}
}
