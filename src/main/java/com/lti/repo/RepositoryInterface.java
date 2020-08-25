package com.lti.repo;

import java.util.List;

import com.lti.model.*;

public interface RepositoryInterface {

	//User
	public long registerUser(UserTable user);
	public List<UserTable> fetchAllUsers();
	boolean isUserPresent(String userEmail);
	public UserTable findById(long userId);
	public UserTable findUserByUserID(long userId);
	public long findUserIdByEmailAndPassword(String userEmail, String userPass);
	public void removeUserByUserID(long userId);
	
	//Admin
	public long registerAdmin(Admin admin);
	
	//Account
	public String registerAccount(Account account);
	
	//Loan
	public long registerLoan(Loan loan);
	
	//Vehicle
	public long registerVehicle(Vehicle vehicle);
	
	
	public List<Loan> viewAllLoans();
	
	public Loan getLoanById(long loanId);
	
	public void removeLoanById(long loanId);
	
	public Loan retrieveLoanByloanType(String loan);
	
	public void removeLoanByApplicationStatus(String applicationStatus);
	
}
