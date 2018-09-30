package com.userdatabase.userdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdatabase.userdemo.database.UserRepository;
import com.userdatabase.userdemo.entity.User;
import com.userdatabase.userdemo.exception.UserAlreadyExistsException;
import com.userdatabase.userdemo.exception.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	static UserRepository repository;

	public void saveUser(User user) throws UserAlreadyExistsException {

		String email = user.getEmail();
		String phone = user.getPhoneNo();

		User findByEmailAddress = repository.findByEmailAddress(email);
		User findByPhoneNo = repository.findByPhoneNo(phone);

		if ((findByEmailAddress != null) || (findByPhoneNo != null)) {
			throw new UserAlreadyExistsException("User with same email id or phone no exists!");
		}

		repository.save(user);
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