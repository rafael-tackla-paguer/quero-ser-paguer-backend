package com.pag.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pag.backend.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findAllByCustomerId(Integer id);

	@Query("from pedido _this where _this.customer.id =:customerId ")
	public Page<Order> findAllByCustomerId(@Param("customerId") Integer idCustomer, Pageable pageable);
}
