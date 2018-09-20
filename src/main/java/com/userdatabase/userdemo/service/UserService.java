package com.userdatabase.userdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdatabase.userdemo.database.UserRepository;
import com.userdatabase.userdemo.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public Optional<User> findUser(String userId) {
		Optional<User> user = repository.findById(userId);
		return user;
	}

	public void saveUser(User user) {
		repository.save(user);
	}

	public void deleteUser(String userId) {
		repository.deleteById(userId);
	}

	// TODO Make password variable, change code
	public boolean validateUser(String user, String password) {
		if (user.equals("Ira") && password.equals("mypassword")) {
			return true;
		}
		return false;
	}
}
