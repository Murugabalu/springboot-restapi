package com.learning.restservices.exceptions;

import java.util.Date;

public class CustomException {
	
	private Date timestamp;
	private String message;
	private String detailedException;
	
	public CustomException(Date timestamp, String message, String detailedException) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detailedException = detailedException;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetailedException() {
		return detailedException;
	}
	
}
