package com.userdatabase.userdemo.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 100L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
