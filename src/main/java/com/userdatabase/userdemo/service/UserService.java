package com.userdatabase.userdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdatabase.userdemo.database.UserRepository;
import com.userdatabase.userdemo.entity.User;
import com.userdatabase.userdemo.exception.UserCredentialDuplicateException;
import com.userdatabase.userdemo.exception.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public void saveUser(User user) {

		try {
			repository.save(user);
		} catch (Exception e) {
			throw new UserCredentialDuplicateException(
					"The Email ID and/or Phone Number already exists for another user!");
		}
	}

	public User findUser(String userId) {

		Optional<User> user = repository.findById(userId);

		if (!user.isPresent()) {
			throw new UserNotFoundException("oops!!! something went wrong... user not found");
		}

		return user.get();
	}

	public void deleteUser(String userId) {

		User userToDelete = findUser(userId);
		if (userToDelete == null) {
			throw new UserNotFoundException("oops!!! something went wrong... user not found");
		}
		repository.deleteById(userId);
	}

}
