package com.learning.restservices.exceptions;

import javax.transaction.SystemException;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
