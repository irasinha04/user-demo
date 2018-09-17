package com.userdatabase.userdemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userdatabase.userdemo.database.UserRepository;
import com.userdatabase.userdemo.entity.User;

@RestController
public class UserController {
	@Autowired
	UserRepository repository;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String create(@RequestBody User user) {

		repository.save(user);
		return user.getId();
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public Optional<User> fetch(@PathVariable String userId) {
		return repository.findById(userId);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	public User update(@PathVariable String userId, @RequestBody User user) {
		Optional<User> userToUpdate = repository.findById(userId);
		if (user.getName() != null)

			userToUpdate.get().setName(user.getName());
		if (user.getEmail() != null)
			userToUpdate.get().setEmail(user.getEmail());
		;
		if (user.getPhoneNo() != null)
			userToUpdate.get().setPhoneNo(user.getPhoneNo());

		repository.save(userToUpdate.get());
		return userToUpdate.get();
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String userId) {
		repository.deleteById(userId);
		return "User deleted!";
	}

}
