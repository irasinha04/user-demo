package com.userdatabase.userdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userdatabase.userdemo.entity.Users;
import com.userdatabase.userdemo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.POST)
	public String create(@RequestBody Users user) {

		service.saveUser(user);
		return user.getId();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)

	public Users fetch(@PathVariable String userId) {
		Users userToFetch = service.findUser(userId);

		return userToFetch;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public Users update(@PathVariable String userId, @RequestBody Users user) {

		Users userToUpdate = service.findUser(userId);

		if (user.getName() != null)

			userToUpdate.setName(user.getName());
		if (user.getEmail() != null)
			userToUpdate.setEmail(user.getEmail());

		if (user.getPhoneNo() != null)
			userToUpdate.setPhoneNo(user.getPhoneNo());

		service.saveUser(userToUpdate);
		return userToUpdate;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String userId) {

		service.deleteUser(userId);
		return "User deleted!";

	}

}
