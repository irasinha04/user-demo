package com.userdatabase.userdemo.exception;

public class TokenNotActiveException extends RuntimeException {
	private static final long serialVersionUID = 102L;

	public TokenNotActiveException(String message) {
		super(message);
	}
}
