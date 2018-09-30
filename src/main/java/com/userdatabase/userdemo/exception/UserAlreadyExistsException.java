package com.userdatabase.userdemo.exception;

public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 100L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}
}