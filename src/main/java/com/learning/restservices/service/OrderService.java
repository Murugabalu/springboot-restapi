package com.learning.restservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.restservices.entities.Order;
import com.learning.restservices.entities.User;
import com.learning.restservices.exceptions.OrderNotFoundException;
import com.learning.restservices.exceptions.UserNotFoundException;
import com.learning.restservices.repository.OrderRepository;
import com.learning.restservices.repository.UserRepository;

@Service
public class OrderService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> getOrdersForUserId(Long userId) throws UserNotFoundException{
		
		Optional<User> user = userRepository.findById(userId);
		
		if(!user.isPresent())
			throw new UserNotFoundException("User id not found in the repository.");
		
		return user.get().getOrders();
		
	}

	public Order createOrderForUserId(Long userId, Order order) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(userId);
		
		if(!optionalUser.isPresent())
			throw new UserNotFoundException("User id not found in the repository.");
		
		User user = optionalUser.get();
		order.setUser(user);
		Order newOrder = orderRepository.save(order);
		return newOrder;
	}

	public Order getOrderForUserIdByOrderId(Long userId, Long orderId) throws UserNotFoundException, OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(userId);
		
		if(!optionalUser.isPresent())
			throw new UserNotFoundException("User id not found in the repository.");
		
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		
		if(!optionalOrder.isPresent())
			throw new OrderNotFoundException("OrderId not found for the userId");
		
		return optionalOrder.get();
	}

}
