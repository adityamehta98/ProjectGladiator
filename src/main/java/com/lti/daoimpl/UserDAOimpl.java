package com.lti.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.lti.dao.UserDAO;
import com.lti.model.User;


@Repository
public class UserDAOimpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		String query = "select userid from User where email=:x and password=:y";
		Query q = (Query) this.entityManager.createQuery(query);
		q.setParameter("x", email);
		q.setParameter("y", password);
		System.out.println("Result is :"+q.getSingleResult());
		return (int)q.getSingleResult();
	}
	//test
	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		String query = "from User where email=:x";
		Query q = (Query) this.entityManager.createQuery(query);
		q.setParameter("x", email);
		return (User)q.getSingleResult();
	}
	
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User updateUser(int userid, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserById(int userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public void save(User user) {
		entityManager.merge(user);
	
	
	}
}