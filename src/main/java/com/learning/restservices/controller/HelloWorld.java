package com.learning.restservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.restservices.model.UserDetails;

@RestController
public class HelloWorld {
	
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello, World!!!";
	}
	
	@GetMapping("/user")
	public UserDetails getUser() {
		return new UserDetails("Murugabalu", "S", "Erode");
	}

}
