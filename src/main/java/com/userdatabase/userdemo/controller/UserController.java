package com.userdatabase.userdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userdatabase.userdemo.entity.Login;
import com.userdatabase.userdemo.entity.User;
import com.userdatabase.userdemo.entity.UserToken;
import com.userdatabase.userdemo.exception.TokenNotActiveException;
import com.userdatabase.userdemo.exception.TokenNotValidException;
import com.userdatabase.userdemo.service.TokenService;
import com.userdatabase.userdemo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private TokenService tokenService;

	@RequestMapping(method = RequestMethod.POST)
	public String create(@RequestBody User user) {

		userService.saveUser(user);
		return user.getUserId();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserToken loginUser(@RequestBody Login login) {
		User user = userService.authenticateUser(login);

		return tokenService.createToken(user.getUserId());

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logoutUser(@RequestHeader(value = "User-Token") String userToken) {

		UserToken readToken = tokenService.readToken(userToken);

		if (!readToken.isActive()) {
			throw new TokenNotActiveException("Session expired !");
		}

		tokenService.logout(readToken.getToken());

	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)

	public String fetch(@PathVariable String userId) {
		User userToFetch = userService.findUser(userId);

		String userToDisplay = userToFetch.toString();

		return userToDisplay;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public User update(@RequestHeader(value = "User-Token") String userToken, @RequestBody User user) {
		UserToken readToken = tokenService.readToken(userToken);

		User userToUpdate = userService.findUser(readToken.getUserId());

		if (!readToken.isActive()) {
			throw new TokenNotActiveException("Session expired ! Please login again.");
		}

		if (!userToUpdate.getUserId().equals(readToken.getUserId())) {
			throw new TokenNotValidException("Access not allowed !");
		}

		if (user.getName() != null)

			userToUpdate.setName(user.getName());
		if (user.getEmail() != null)
			userToUpdate.setEmail(user.getEmail());

		if (user.getPhoneNo() != null)
			userToUpdate.setPhoneNo(user.getPhoneNo());

		userService.saveUser(userToUpdate);
		return userToUpdate;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String delete(@RequestHeader(value = "User-Token") String userToken, @PathVariable String userId) {

		UserToken readToken = tokenService.readToken(userToken);

		User userToUpdate = userService.findUser(readToken.getUserId());

		if (!readToken.isActive()) {
			throw new TokenNotActiveException("Session expired ! Please login again.");
		}

		if (!userToUpdate.getUserId().equals(readToken.getUserId())) {
			throw new TokenNotValidException("Access not allowed !");
		}

		userService.deleteUser(userId);
		return "User deleted!";

	}

}
