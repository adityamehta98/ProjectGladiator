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
	

	@Override
	@Transactional
	public long registerAdmin(Admin admin) {
		Admin a = em.merge(admin);
		return a.getAdminId();
	}

	@Override
	@Transactional
	public long registerUser(UserTable user) {
		UserTable u = em.merge(user);
		return u.getUserId();
	}

	@Override
	@Transactional
	public String registerAccount(Account account) {
		Account a = em.merge(account);
		return a.getAccNumber();
	}


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
	
	
	
	//Added these methods for loan

	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Loan> viewAllLoans() {
		return em
				.createNamedQuery("Loan.findAll")
				.getResultList();
	}
/*
	@Override
	@Transactional
	public Loan retrieveLoanByloanType(String loan) {
		return em.find(Loan.class, loanType);
	}
	
*/

	@Override
	@Transactional
	public Loan getLoanById(long loanId) {
		return em.find(Loan.class, loanId);
	}

	@Override
	@Transactional
	public void removeLoanById(long loanId) {
		Loan loan = em.find(Loan.class, loanId);
		em.remove(loan);
	}

	@Override
	@Transactional
	public void removeLoanByApplicationStatus(String applicationStatus) {
		em
		.createQuery("delete from Loan where applicationStatus = :appStatus")
		.setParameter("appStatus", applicationStatus);
	}

	@Override
	@Transactional
	public Loan retrieveLoanByloanType(String loan) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
