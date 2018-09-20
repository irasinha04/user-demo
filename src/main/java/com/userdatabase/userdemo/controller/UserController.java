package com.userdatabase.userdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userdatabase.userdemo.entity.User;
import com.userdatabase.userdemo.exception.UserException;
import com.userdatabase.userdemo.service.UserService;

//A try block here for 404 page not found

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
	public User fetch(@PathVariable String userId) {

		try {
			return service.findUser(userId);
		} catch (UserException e) {
			if (e.getMessage() == null) {
				System.out.println(e.getClass().getName());
			} else {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public User update(@PathVariable String userId, @RequestBody User user) {

		try {
			User userToUpdate = service.findUser(userId);

			if (user.getName() != null)

				userToUpdate.setName(user.getName());
			if (user.getEmail() != null)
				userToUpdate.setEmail(user.getEmail());

			if (user.getPhoneNo() != null)
				userToUpdate.setPhoneNo(user.getPhoneNo());

			service.saveUser(userToUpdate);
			return userToUpdate;
		} catch (UserException e) {
			if (e.getMessage() == null) {
				System.out.println(e.getClass().getName());
			} else {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String userId) {

		try {
			service.deleteUser(userId);
			return "User deleted!";
		} catch (UserException e) {
			if (e.getMessage() == null) {
				System.out.println(e.getClass().getName());
			} else {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

}
