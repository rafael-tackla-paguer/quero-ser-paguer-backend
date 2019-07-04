package com.pag.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pag.backend.domain.Customer;
import com.pag.backend.repository.CustomerRepository;
import com.pag.backend.service.CustomerService;
import com.pag.backend.service.exception.NotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return repository.save(customer);
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
	public Customer findById(Long id) {
		Optional<Customer> result = repository.findById(id);
		return result.orElseThrow(()-> new NotFoundException() );
	}

}
