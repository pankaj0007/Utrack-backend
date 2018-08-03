package com.utrack.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.utrack.backend.dao.UserDAO;
import com.utrack.backend.model.UserDO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public Long createUser(UserDO user) {
		System.out.println("hash password : " + BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
		return userDAO.createUser(user);
	}

	@Override
	public List<UserDO> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	public UserDO getUserbyId(Long id) {
		return userDAO.getUserbyId(id);
	}

	@Override
	public void deleteUserById(Long id) {
		userDAO.deleteUserById(id);
	}

	@Override
	public UserDO updateUsebyId(Long id, UserDO user) throws Exception {
		return userDAO.updateUserById(id, user);
	}

	@Override
	public UserDO getUserbyName(String username) {
		// TODO Auto-generated method stub
		return userDAO.findUserByName(username);
	}

}
