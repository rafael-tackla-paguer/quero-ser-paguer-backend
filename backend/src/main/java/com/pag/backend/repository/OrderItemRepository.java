package com.pag.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pag.backend.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

	@Query("from item_pedido _this where _this.order.id =:orderId")
	List<OrderItem> findAllByOrderId(@Param("orderId") Integer orderId);

}
