package com.pag.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pag.backend.domain.Customer;
import com.pag.backend.model.PageModel;
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
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Customer> findAll() {
		return repository.findAll();
	}
	
	@Override
	public PageModel<Customer> findAll(Pageable pageable) {
		Page<Customer> pagedResult = repository.findAll(pageable);
		PageModel<Customer> pageModel= new PageModel<Customer>(pagedResult.getTotalElements(), pagedResult.getSize(), pagedResult.getTotalPages(), pagedResult.getContent());
		return pageModel;
	}

	@Override
	public Customer findById(Integer id) {
		Optional<Customer> result = repository.findById(id);
		return result.orElseThrow(()-> new NotFoundException() );
	}
}
