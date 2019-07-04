package com.pag.backend.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pag.backend.service.OrderService;

@RestController
@RequestMapping(value = "orders")
public class OrderResource {

	@Autowired
	private OrderService service;
}
