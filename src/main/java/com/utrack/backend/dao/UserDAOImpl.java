package com.utrack.backend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utrack.backend.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(user);
	}

	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> list = session.createCriteria(User.class).list();
		return list;
	}

	@Override
	public User getUserbyId(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}

}
