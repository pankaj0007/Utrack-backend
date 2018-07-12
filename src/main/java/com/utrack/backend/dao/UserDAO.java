package com.utrack.backend.dao;

import java.util.List;

import com.utrack.backend.model.User;

public interface UserDAO {

	public int createUser(User user);

	public List<User> getUsers();

	public User findUserByName(String username);

	public User getUserbyId(int id);

	public void deleteUserById(int id);

	public User updateUserById(int id, User user) throws Exception;
}
