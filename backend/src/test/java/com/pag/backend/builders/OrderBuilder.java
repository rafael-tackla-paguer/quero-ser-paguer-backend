package com.pag.backend.builders;

import static com.pag.backend.builders.CustomerBuilder.oneCustomer;
import static com.pag.backend.builders.OrderItemBuilder.oneOrderItem;
import static java.math.BigDecimal.ONE;

import java.math.BigDecimal;
import java.util.Arrays;

import com.pag.backend.domain.Customer;
import com.pag.backend.domain.Order;
import com.pag.backend.domain.OrderItem;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderBuilder {
	private Order order;
	
	public static OrderBuilder oneOrder() {
		OrderBuilder builder = new OrderBuilder();
		initDefaulValues(builder);
		return builder; 
	}
	
	public static void initDefaulValues(OrderBuilder builder) {
		builder.order = new Order();
		Order element = builder.order;
		element.setCustomer(oneCustomer().now());
		element.setOrderItems(Arrays.asList(oneOrderItem().now()));
		element.setValue(ONE);
	}
	
	public OrderBuilder withCustomer(Customer customer) {
		order.setCustomer(customer);
		return this;
	}
	
	public OrderBuilder withListOrderItems(OrderItem... orderItems) {
		order.setOrderItems(Arrays.asList(orderItems));
		return this;
	}
	
	public OrderBuilder withValue(BigDecimal value) {
		order.setValue(ONE);
		return this;
	}
	
	public Order now() {
		return order;
	}
	
}
