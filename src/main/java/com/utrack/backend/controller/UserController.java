package com.utrack.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.utrack.backend.model.UserDO;
import com.utrack.backend.service.UserService;

@RestController
@RequestMapping("/utrack")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Object> getUser() {
		List<UserDO> userList = userService.getUsers();
		return new ResponseEntity<Object>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createUser(@RequestBody UserDO user, UriComponentsBuilder ucBuilder) {
		Long id = userService.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ACCOUNT')")
	public ResponseEntity<UserDO> getUserById(@PathVariable("id") Long id) {
		UserDO user = userService.getUserbyId(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserDO> deleteUserById(@PathVariable("id") Long id) {
		UserDO user = userService.getUserbyId(id);
		userService.deleteUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDO> updateUserById(@RequestBody UserDO updatedUser, @PathVariable("id") Long id) {
		UserDO user = null;
		try {
			user = userService.updateUsebyId(id, updatedUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
