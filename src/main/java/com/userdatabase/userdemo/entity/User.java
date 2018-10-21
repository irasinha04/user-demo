package com.userdatabase.userdemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String userId;

	private String name;

	@Indexed(unique = true)
	private String username;

	private String password;

	@Indexed(unique = true)
	private String email;

	@Indexed(unique = true)
	private String phoneNo;

	// Constructor
	public User(String name, String username, String password, String email, String phoneNo) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;

	}

	public User() {
	}

	// Getters and Setters
	public String getUserId() {
		return userId;
	}

	public void setUserId(String id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	// toString
	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + "]";
	}

}
