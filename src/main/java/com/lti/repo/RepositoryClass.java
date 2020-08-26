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
	
	
	// User Register Implementation

	@Override
	@Transactional
	public long registerUser(UserTable user) {
		UserTable u = em.merge(user);
		return u.getUserId();
	}
	
	// User Login Implementation
	
	@Override
	@Transactional
	public boolean isUserPresent(String userEmail) {
		return (long) em
				.createQuery("select count(u.userId) from UserTable u where u.userEmail = :em ")
				.setParameter("em", userEmail)
				.getSingleResult() == 1 ? true : false;
	}
	
	@Override
	@Transactional
	public long findUserIdByEmailAndPassword(String userEmail, String userPass) {
		return (long) em
				.createQuery("select id from UserTable where userEmail = :em and userPass = :pw ")
				.setParameter("em", userEmail)
				.setParameter("pw", userPass)
				.getSingleResult();
	}
	
	//Finding User Object After Login (Dashboard Use)
	
	@Override
	@Transactional
	public UserTable findUserByUserID(long userId) {
		UserTable res = em.find(UserTable.class, userId);
		return res;
	}
	
	// Remove User By UserID
	
	@Override
	@Transactional
	public void removeUserByUserID(long userId) {
		UserTable user = em.find(UserTable.class, userId);
		em.remove(user);
	}
	
	// Create Account
	
	@Override
	@Transactional
	public String registerAccount(Account account) {
		Account a = em.merge(account);
		return a.getAccNumber();
	}
	
	// Vehicle Implementation
	
	@Override
	@Transactional
	public String registerVehicle(Vehicle vehicle) {
		Vehicle veh = em.merge(vehicle);
		return veh.getVehicleId();
	}	
	
	// Apply Loan 
	
	@Override
	@Transactional
	public boolean isVehiclePresent(String vehicleId) {
		return (long) em
				.createQuery("select count(v) from Vehicle v where v.vehicleId = :vid")
				.setParameter("vid", vehicleId)
				.getSingleResult() == 1 ? true : false;
	}
	
	@Override
	@Transactional
	public long registerLoan(Loan loan) {
		Loan l = em.merge(loan);
		return l.getLoanId();
	}
		
		
	// Document Implementation (To be Done)
		
		
	
//----------------------------------------------------------------------
		
	// Admin Registration
	
	@Override
	@Transactional
	public long registerAdmin(Admin admin) {
		Admin a = em.merge(admin);
		return a.getAdminId();
	}

		
	// Admin Login
	
	@Override
	@Transactional
	public boolean isAdminPresent(String adminEmail) {
		return (long) em
				.createQuery("select count(adminId) from Admin where adminEmail = :email ")
				.setParameter("email", adminEmail)
				.getSingleResult() == 1 ? true : false;
	}

	@Override
	@Transactional
	public long findAdminIdByEmailAndPassword(String adminEmail, String adminPass) {
		return (long) em
				.createQuery("select id from Admin where adminEmail = :em and adminPass = :pw ")
				.setParameter("em", adminEmail)
				.setParameter("pw", adminPass)
				.getSingleResult();
	}

	@Override
	public Admin findAdminById(long adminId) {
		return em.find(Admin.class, adminId);
	}
			
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserTable> fetchAllRegisteredUsers() {
		return em
				.createNamedQuery("UserTable.findAll")
				.getResultList();
	}	
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserTable> allApprovedUsers() {
		return em
				.createQuery("select u from UserTable u where u.loan = (select l.loanId from Loan l where l.applicationStatus = 'Approved')")
				.getResultList();
	}
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserTable> allPendingUsers() {
		return em
				.createQuery("select u from UserTable u where u.loan = (select l.loanId from Loan l where l.applicationStatus = 'Pending')")
				.getResultList();
	}
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserTable> allRejectedUsers() {
		return em
				.createQuery("select u from UserTable u where u.loan = (select l.loanId from Loan l where l.applicationStatus = 'Rejected')")
				.getResultList();
	}
		
	@Override
	@Transactional
	public void approveLoan(long loanId) {
		em.createQuery("update Loan l set l.applicationStatus = 'Approved' where l.loanId =:id ")
		.setParameter("id", loanId)
		.executeUpdate();
	}
	
	@Override
	@Transactional
	public void rejectLoan(long loanId) {
		em.createQuery("update Loan l set l.applicationStatus = 'Rejected' where l.loanId =:id ")
		.setParameter("id", loanId)
		.executeUpdate();
	}
	
	//-------------------------------------------------------------

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