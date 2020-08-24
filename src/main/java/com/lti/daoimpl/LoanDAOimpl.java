package com.lti.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.lti.dao.LoanDAO;
import com.lti.model.Account;
import com.lti.model.Loan;

@Repository
public class LoanDAOimpl implements LoanDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addLoan(Loan loan) {
		entityManager.merge(loan);
	}

	@Override
	public List<Loan> retrieveLoan() {
		return entityManager
				.createNamedQuery("fetch-all")
				.getResultList();
	}

	@Override
	public void removeLoan(int userid) {
		Loan loan = findLoanByUserId(userid);
		entityManager.remove(loan);
		
	}

	@Override
	public Loan findLoanByUserId(int userid) {
		return entityManager.find(Loan.class, userid);
	}

	@Override
	public Loan findLoanByLoanId(int loanId) {
		return entityManager.find(Loan.class, loanId);
	}
}