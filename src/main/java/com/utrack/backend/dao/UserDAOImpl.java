package com.utrack.backend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utrack.backend.model.UserDO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long createUser(UserDO user) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(user);
	}

	@Override
	public List<UserDO> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDO> list = session.createCriteria(UserDO.class).list();
		return list;
	}

	@Override
	public UserDO getUserbyId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(UserDO.class, id);
	}

	@Override
	public UserDO findUserByName(String username) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDO.class);
		criteria.add(Expression.eq("name", username));
		UserDO user = (UserDO) criteria.uniqueResult();
		return user;
	}

	@Override
	public void deleteUserById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		UserDO user = session.get(UserDO.class, id);
		session.delete(user);
	}

	@Override
	public UserDO updateUserById(Long id, UserDO updatedUser) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		UserDO user = session.get(UserDO.class, id);
		updatedUser.createPreviousRecord(user);
		session.evict(user);
		if (user == null) {
			throw new Exception("User not available");
		}
		updatedUser.setId(id);
		session.update(updatedUser);
		return updatedUser;
	}

}
