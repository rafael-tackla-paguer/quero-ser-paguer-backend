package com.pag.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pag.backend.domain.Customer;
import com.pag.backend.repository.CustomerRepository;
import com.pag.backend.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Optional<Customer> update(Long id, Customer customer) {
		return repository.findById(id).map(updateCustomer -> {
			updateCustomer.setBirthDate(customer.getBirthDate());
			updateCustomer.setCpf(customer.getCpf());
			updateCustomer.setName(customer.getName());
			return repository.save(updateCustomer);
		});
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Customer> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

}
