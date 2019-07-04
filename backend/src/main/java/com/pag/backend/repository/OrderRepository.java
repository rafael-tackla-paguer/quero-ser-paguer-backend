package com.pag.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pag.backend.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findAllByCustomerId(Long id);
}
