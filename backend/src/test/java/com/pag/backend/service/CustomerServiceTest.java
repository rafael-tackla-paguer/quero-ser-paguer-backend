package com.pag.backend.service;

import static com.pag.backend.builders.CustomerBuilder.oneCustomer;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pag.backend.domain.Customer;
import com.pag.backend.repository.CustomerRepository;
import com.pag.backend.service.exception.NotFoundException;
import com.pag.backend.service.impl.CustomerServiceImpl;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

	@Autowired
	private CustomerService service;
	
	@MockBean
	private CustomerRepository repository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	 @TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
  
        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }
	
	
	@Test
	public void findByIdSuccessTest() {
		//cenário
		Customer customer = oneCustomer()
								.withCpf("01234567890")
								.withName("João")
								.now();
		Optional<Customer> expectedReturn =  Optional.of(customer);
		when(repository.findById(1)).thenReturn(expectedReturn);
		
		//ação
		Customer savedCustomer = service.findById(1);
		
		//verificação
		verify(repository).findById(1);
		assertEquals(customer, savedCustomer);
		
	}
		
	@Test(expected = NotFoundException.class)
	public void findByIdNotFoundExceptionTest() {
		//cenário
		Customer customer = oneCustomer()
								.withCpf("01234567890")
								.withName("João")
								.now();
		Optional<Customer> expectedReturn =  Optional.of(customer);
		when(repository.findById(1)).thenReturn(expectedReturn);
		
		//ação
		service.findById(2);
		
	}

}
