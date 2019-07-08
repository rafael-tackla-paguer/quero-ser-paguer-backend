package com.pag.backend.builders;

import com.pag.backend.domain.Customer;

public class CustomerBuilder {

	private Customer customer;
	
	private CustomerBuilder() {};
	
	public static CustomerBuilder oneCustomer() {
		CustomerBuilder builder = new CustomerBuilder();
		builder.customer = new Customer();
		builder.customer.setName("Cliente 1");
		return builder;
	}
	
	public CustomerBuilder withName(String name) {
		customer.setName(name);
		return this;
	}
	
	public Customer now() {
		return this.customer;
	}
	
}
