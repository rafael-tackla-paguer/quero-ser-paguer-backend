package com.pag.backend.builders;

import java.math.BigDecimal;

import com.pag.backend.domain.OrderItem;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderItemBuilder {

	private OrderItem orderItem;
	
	public static OrderItemBuilder oneOrderItem() {
		OrderItemBuilder builder = new OrderItemBuilder();
		builder.orderItem = new OrderItem();
		return builder;
	}
	
	public OrderItemBuilder withPrice(BigDecimal price) {
		orderItem.setPrice(price);
		return this;
	}
	
	public OrderItemBuilder withAmount(BigDecimal amount) {
		orderItem.setAmount(amount);
		return this;
	}
	
	
	public OrderItem now() {
		return orderItem;
	}
}
