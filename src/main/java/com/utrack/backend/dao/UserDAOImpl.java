package com.utrack.backend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
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

	@Override
	public User findUserByName(String username) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Expression.eq("name", username));
		User user = (User) criteria.uniqueResult();
		return user;
	}

	@Override
	public void deleteUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.delete(user);
	}

	@Override
	public User updateUserById(int id, User updatedUser) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.evict(user);
		if (user == null) {
			throw new Exception("User not available");
		}
		updatedUser.setId(id);
		session.update(updatedUser);
		return updatedUser;
	}

}
