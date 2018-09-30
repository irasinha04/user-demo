package com.userdatabase.userdemo.model;

public class AccessUserError {

	private final String message;

	private AccessUserError(String message) {
		this.message = message;
	}

	public static AccessUserError showMessage(String message) {
		return new AccessUserError(message);
	}

	public String getMessage() {
		return message;
	}
}