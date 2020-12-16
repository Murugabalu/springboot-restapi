package com.learning.restservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.learning.restservices.entities.User;
import com.learning.restservices.exceptions.UserAlreadyExistsException;
import com.learning.restservices.exceptions.UserNotFoundException;
import com.learning.restservices.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public User createUser(User user) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser!=null)
			throw new UserAlreadyExistsException("User already exits in the repository, try a diff User.");
		return userRepository.save(user);
	}

	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User not found in the User Repository");
		
		return userRepository.findById(id);
	}

	public User updateUserById(Long id, User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userFound = userRepository.findById(id);
		if(!userFound.isPresent()) {
			throw new UserNotFoundException("User not found for the given ID, please enter a valid userId.");
		}
		user.setId(id);
		return userRepository.save(user);
	}

	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User ID not found in the User Repository, give a valid id.");
		}
		userRepository.deleteById(id);
	}

	public User getUserByUserName(String user_name) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(user_name);
	}

}
