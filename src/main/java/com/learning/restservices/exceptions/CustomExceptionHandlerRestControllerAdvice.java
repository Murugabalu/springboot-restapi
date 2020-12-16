package com.learning.restservices.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class CustomExceptionHandlerRestControllerAdvice {
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomException userNotFoundException(UserNotFoundException ex) {
		return new CustomException(new Date(), "GEH - RestControllerAdvice", ex.getMessage());
	}

}
