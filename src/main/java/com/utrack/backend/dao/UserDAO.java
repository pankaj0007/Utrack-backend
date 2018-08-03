package com.utrack.backend.dao;

import java.util.List;

import com.utrack.backend.model.UserDO;

public interface UserDAO {

	public Long createUser(UserDO user);

	public List<UserDO> getUsers();

	public UserDO findUserByName(String username);

	public UserDO getUserbyId(Long id);

	public void deleteUserById(Long id);

	public UserDO updateUserById(Long id, UserDO user) throws Exception;
}
