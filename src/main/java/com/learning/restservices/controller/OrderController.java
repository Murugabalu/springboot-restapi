package com.learning.restservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.restservices.entities.Order;
import com.learning.restservices.exceptions.OrderNotFoundException;
import com.learning.restservices.exceptions.UserNotFoundException;
import com.learning.restservices.service.OrderService;

@RestController
@RequestMapping(value="/users")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/{userId}/orders")
	public List<Order> getOrdersForUserId(@PathVariable Long userId) throws UserNotFoundException{
		return orderService.getOrdersForUserId(userId);
	}
	
	@PostMapping("/{userId}/orders")
	public Order createOrder(@PathVariable Long userId,@RequestBody Order order) throws UserNotFoundException {
		return orderService.createOrderForUserId(userId, order);
	}
	
	@GetMapping("/{userId}/orders/{orderId}")
	public Order getOrderForUserIdByOrderId(@PathVariable Long userId,@PathVariable Long orderId) throws UserNotFoundException, OrderNotFoundException {
		return orderService.getOrderForUserIdByOrderId(userId, orderId);
	}

}
