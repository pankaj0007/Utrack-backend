package com.utrack.backend.service;

import java.util.List;

import com.utrack.backend.model.User;

public interface UserService {

	public int createUser(User user);

	public List<User> getUsers();

	public User getUserbyId(int id);
}
