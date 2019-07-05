package com.pag.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pag.backend.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
