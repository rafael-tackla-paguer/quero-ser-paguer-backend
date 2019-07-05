package com.pag.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pag.backend.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findAllByCustomerId(Integer id);
}
