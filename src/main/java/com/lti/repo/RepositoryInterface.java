package com.lti.repo;

import java.util.List;

import com.lti.model.*;

public interface RepositoryInterface {

	public long registerUser(UserTable user); //user registration 
	boolean isUserPresent(String userEmail); //user login (1)
	public long findUserIdByEmailAndPassword(String userEmail, String userPass); // user login (2)
	public UserTable findUserByUserID(long userId); //finding user object after login (dashboard use)
	public void removeUserByUserID(long userId); //remove user 
	
	
	public String registerAccount(Account account); //create account
	public long registerVehicle(Vehicle vehicle); //register vehicle
	public long registerLoan(Loan loan); //apply loan
	// document method (to-do)
	
	//-----------------------------------------------------------------------
	// admin methods 
	
	public long registerAdmin(Admin admin); //register an admin
	boolean isAdminPresent(String adminEmail); //admin login (1)
	public long findAdminIdByEmailAndPassword(String adminEmail, String userPass);
	public Admin findAdminById(long adminId); // admin login (2)
	
	public List<UserTable> fetchAllRegisteredUsers(); // find all registered users 

	public List<UserTable> allApprovedUsers(); //approved user list
	public List<UserTable> allPendingUsers(); //pending user list
	public List<UserTable> allRejectedUsers(); //rejected user list
	public void approveLoan(long loanId); //for loan's approval
	public void rejectLoan(long loanId); //rejecting loan!
	
	
	
	
	
	public List<Loan> viewAllLoans();
	
	public Loan getLoanById(long loanId);
	
	public void removeLoanById(long loanId);
	
	public Loan retrieveLoanByloanType(String loan);
	
	public void removeLoanByApplicationStatus(String applicationStatus);
	
}
