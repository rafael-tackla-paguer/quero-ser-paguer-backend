package com.pag.backend.domain;

import static org.junit.Assert.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.pag.backend.builders.CustomerBuilder;

@RunWith(SpringRunner.class)
public class CustomerTest {

	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void customerNullNameConstraintViolationTest() {
		//cenario
		Customer customer = CustomerBuilder.oneCustomer().withName(null).now();
		
		//acao
		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        
		//verificacao
		assertFalse(violations.isEmpty());		
	}
	
	@Test
	public void customerEmptyNameConstraintViolationTest() {
		//cenario
		Customer customer = CustomerBuilder.oneCustomer().withName("   ").now();
		
		//acao
		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        
		//verificacao
		assertFalse(violations.isEmpty());		
	}
}
