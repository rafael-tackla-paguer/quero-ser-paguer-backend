package com.pag.backend.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pag.backend.domain.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Before
	public void setup() {
		Customer customer = new Customer();
	}
	
	@Test
	public void saveTest() {
		//cenário
		
		//ação
		
		//verificação
	}
	
	@Test
	public void updateTest() {
		//cenário
		
		//ação
		
		//verificação
		
	}

	@Test
	public void findByIdTest() {
		//cenário
		
		//ação
		
		//verificação
		
	}
	
}
