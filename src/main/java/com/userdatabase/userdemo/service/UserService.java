package com.userdatabase.userdemo.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdatabase.userdemo.database.UserRepository;
import com.userdatabase.userdemo.entity.Login;
import com.userdatabase.userdemo.entity.User;
import com.userdatabase.userdemo.exception.UserCredentialDuplicateException;
import com.userdatabase.userdemo.exception.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void saveUser(User user) {

		try {
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(5)));
			userRepository.save(user);
		} catch (Exception e) {
			throw new UserCredentialDuplicateException(
					"The Username/Email ID/Phone Number already exists for another user!");

		}
	}

	public User findUser(String userId) {

		Optional<User> user = userRepository.findById(userId);

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
		userRepository.deleteById(userId);
	}

	public User authenticateUser(Login login) {
		User user = userRepository.findByUsername(login.getUsername());
		if (!BCrypt.checkpw(login.getPassword(), user.getPassword())) {
			throw new UserNotFoundException("Invalid Credentials!");
		}
		return user;
	}

}
