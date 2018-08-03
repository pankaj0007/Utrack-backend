package com.utrack.backend.service;

import java.util.List;

import com.utrack.backend.model.UserDO;

public interface UserService {

	public Long createUser(UserDO user);

	public List<UserDO> getUsers();

	public UserDO getUserbyId(Long id);

	public void deleteUserById(Long id);

	public UserDO updateUsebyId(Long id, UserDO user) throws Exception;

	public UserDO getUserbyName(String username);
}
