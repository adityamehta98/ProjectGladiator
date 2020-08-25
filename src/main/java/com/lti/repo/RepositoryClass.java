package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.*;

@Repository
public class RepositoryClass implements RepositoryInterface {
	
	@PersistenceContext
	EntityManager em;
	
	//UserDAOImpl
	//-----------------------------------------------------------------
	@Override
	@Transactional
	public long registerUser(UserTable user) {
		UserTable u = em.merge(user);
		return u.getUserId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserTable> fetchAllUsers() {
		return em
				.createNamedQuery("UserTable.findAll")
				.getResultList();
	}
	
	@Override
	public UserTable findUserByUserID(long userId) {
		UserTable res = em.find(UserTable.class, userId);
		return res;
	}

	@Override
	public long findUserIdByEmailAndPassword(String userEmail, String userPass) {
		return (long) em
				.createQuery("select id from UserTable where userEmail = :em and userPass = :pw ")
				.setParameter("em", userEmail)
				.setParameter("pw", userPass)
				.getSingleResult();
	}

	@Override
	@Transactional
	public void removeUserByUserID(long userId) {
		UserTable user = em.find(UserTable.class, userId);
		em.remove(user);
	}
	
	@Override
	public boolean isUserPresent(String userEmail) {
		return (long) em
				.createQuery("select count(u.userId) from UserTable u where u.userEmail = :em ")
				.setParameter("em", userEmail)
				.getSingleResult() == 1 ? true : false;
	}
	
	@Override
	public UserTable findById(long userId) {
		return em.find(UserTable.class, userId);
	}
	//--------------------------------------------------------------
	//AdminDAOImpl
	
	@Override
	@Transactional
	public long registerAdmin(Admin admin) {
		Admin a = em.merge(admin);
		return a.getAdminId();
	}

	@Override
	@Transactional
	public String registerAccount(Account account) {
		Account a = em.merge(account);
		return a.getAccNumber();
	}

	//NEW
	@Override
	@Transactional
	public long registerLoan(Loan loan) {
		Loan l = em.merge(loan);
		return l.getLoanId();
	}


	@Override
	@Transactional
	public long registerVehicle(Vehicle vehicle) {
		Vehicle v = em.merge(vehicle);
		return v.getVehicleId();
	}


}