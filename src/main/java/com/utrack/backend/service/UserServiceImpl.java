package com.utrack.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utrack.backend.dao.UserDAO;
import com.utrack.backend.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public int createUser(User user) {
		return userDAO.createUser(user);
	}

	@Override
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public User getUserbyId(int id) {
		return userDAO.getUserbyId(id);
	}

}
