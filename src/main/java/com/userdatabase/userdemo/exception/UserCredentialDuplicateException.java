package com.userdatabase.userdemo.exception;

public class UserCredentialDuplicateException extends RuntimeException {
	private static final long serialVersionUID = 101L;

	public UserCredentialDuplicateException(String message) {
		super(message);
	}
}
