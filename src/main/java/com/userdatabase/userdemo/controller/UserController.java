package com.userdatabase.userdemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userdatabase.userdemo.entity.User;
import com.userdatabase.userdemo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(method = RequestMethod.POST)
	public String create(@RequestBody User user) {

		service.saveUser(user);
		return user.getId();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Optional<User> fetch(@PathVariable String userId) {
		return service.findUser(userId);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public Optional<User> update(@PathVariable String userId, @RequestBody User user) {

		Optional<User> userToUpdate = service.findUser(userId);

		if (userToUpdate.isPresent())

		{
			if (user.getName() != null)

				userToUpdate.get().setName(user.getName());
			if (user.getEmail() != null)
				userToUpdate.get().setEmail(user.getEmail());

			if (user.getPhoneNo() != null)
				userToUpdate.get().setPhoneNo(user.getPhoneNo());

			service.saveUser(userToUpdate.get());
			return userToUpdate;
		}
		return null;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String userId) {

		service.deleteUser(userId);
		return "User deleted!";
	}

}
