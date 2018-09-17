package com.userdatabase.userdemo.entity;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	String id;
	String name;
	String email;
	String phoneNo;

	// Constructor
	public User(String name, String email, String phoneNo) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public User() {
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	// public void setId(int id) {
	// this.id = id;
	// }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + "]";
	}

}
