package com.userdatabase.userdemo.exception;

public class TokenNotValidException extends RuntimeException {
	private static final long serialVersionUID = 102L;

	public TokenNotValidException(String message) {
		super(message);
	}
}
