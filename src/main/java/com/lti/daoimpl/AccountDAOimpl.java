package com.lti.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dao.AccountDAO;
import com.lti.model.Account;
import com.lti.model.User;


@Repository
public class AccountDAOimpl implements AccountDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void addAccount(Account account) {
		entityManager.merge(account);
	}
	
	@Override
	public List<Account> retrieveAccount() {
		return entityManager
				.createNamedQuery("fetch-all")
				.getResultList();
	}
	
	@Override
	public Account findAccountByUserId(int userid) {
		return entityManager.find(Account.class, userid);
	}

	@Override
	public void removeAccount(int userid) {
		Account account = findAccountByUserId(userid);
		entityManager.remove(account);
		
	}
	
}
