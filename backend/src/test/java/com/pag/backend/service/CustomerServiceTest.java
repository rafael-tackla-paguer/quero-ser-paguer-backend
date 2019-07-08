package com.pag.backend.service;

import static com.pag.backend.builders.CustomerBuilder.oneCustomer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pag.backend.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService service;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveTest() {
		//cenário
		oneCustomer().now();
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
