package com.userdatabase.userdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdatabase.userdemo.database.UserRepository;
import com.userdatabase.userdemo.entity.User;
import com.userdatabase.userdemo.exception.UserException;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public void saveUser(User user) {
		repository.save(user);
	}

	public User findUser(String userId) throws UserException {

		// Exception for if there is no user with given User Id
		Optional<User> user = repository.findById(userId);
		if (user == null) {
			throw new UserException("No such record found for User id :" + userId);
		}

		return user.get();
	}

	public void deleteUser(String userId) throws UserException {
		User user = findUser(userId);

		// Exception for if the person trying to delete information is not valid
		if (!(isUserValid(user, user.getName(), user.getPassword()))) {
			throw new UserException("You are not valid!");
		}
		repository.deleteById(userId);
	}

	public boolean isUserValid(User user, String userName, String userPassword) {
		if (user.getName().equals(userName) && user.getPassword().equals(userPassword)) {
			return true;
		}
		return false;
	}
}
