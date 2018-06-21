package com.utrack.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utrack.backend.model.User;
import com.utrack.backend.model.User.Role;
import com.utrack.backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Object> getUser() {
		User user = new User("admin", "admin", Role.emp);
		User retrivedUser = userService.createUser(user);
		return new ResponseEntity<Object>(retrivedUser, HttpStatus.OK);
	}
}
