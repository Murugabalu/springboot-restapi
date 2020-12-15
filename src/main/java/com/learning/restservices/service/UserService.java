package com.learning.restservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.restservices.entities.User;
import com.learning.restservices.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	public User updateUserById(Long id, User user) {
		// TODO Auto-generated method stub
		user.setId(id);
		return userRepository.save(user);
	}

	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}

	public User getUserByUserName(String user_name) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(user_name);
	}

}
