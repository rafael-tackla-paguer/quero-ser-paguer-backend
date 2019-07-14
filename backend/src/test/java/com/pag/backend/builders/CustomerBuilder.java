package com.pag.backend.builders;

import java.util.Date;

import com.pag.backend.domain.Customer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerBuilder {

	private Customer customer;
	
	public static CustomerBuilder oneCustomer() {
		CustomerBuilder builder = new CustomerBuilder();
		builder.customer = new Customer();
		builder.customer.setName("Cliente 1");
		builder.customer.setCpf("11111111111");
		builder.customer.setBirthDate(new Date());
		return builder;
	}
	
	public CustomerBuilder withName(String name) {
		customer.setName(name);
		return this;
	}
	
	public CustomerBuilder withCpf(String cpf) {
		customer.setCpf(cpf);
		return this;
	}
	
	public Customer now() {
		return this.customer;
	}
	
}
