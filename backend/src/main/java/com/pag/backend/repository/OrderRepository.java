package com.pag.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pag.backend.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
