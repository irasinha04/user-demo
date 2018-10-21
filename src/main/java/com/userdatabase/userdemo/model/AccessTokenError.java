package com.userdatabase.userdemo.model;

public class AccessTokenError {
	private final String message;

	private AccessTokenError(String message) {
		this.message = message;
	}

	public static AccessTokenError showMessage(String message) {
		return new AccessTokenError(message);
	}

	public String getMessage() {
		return message;
	}
}
