package com.userdatabase.userdemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserToken {
	@Id
	private String token;

	private String userId;

	private boolean isActive;

	public UserToken() {
	}

	public UserToken(String userId, String token, boolean isActive) {
		super();
		this.userId = userId;
		this.token = token;
		this.isActive = isActive;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
