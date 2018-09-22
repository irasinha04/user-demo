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

	public void saveUser(User user) {
		repository.save(user);
	}

	public User findUser(String userId) throws Exception {

		// Exception for if there is no user with given User Id
		Optional<User> user = repository.findById(userId);
		return user.get();
	}

	public void deleteUser(String userId) throws Exception {

		// Exception for if the person trying to delete information is not valid
		repository.deleteById(userId);
	}

}
