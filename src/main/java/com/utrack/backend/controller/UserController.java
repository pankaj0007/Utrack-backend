package com.utrack.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utrack.backend.model.User;
import com.utrack.backend.model.User.Role;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping(value="/" , method= RequestMethod.GET)
	public ResponseEntity<Object>  getUser() {
	    User user = new User("admin" , "admin", Role.emp);
		return new ResponseEntity<Object>(user, HttpStatus.OK); 
	}
}
