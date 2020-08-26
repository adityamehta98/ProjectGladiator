package com.lti.service;

import java.util.List;

import com.lti.model.*;

public interface UserService {

	void register(UserTable user);

	UserTable login(String email, String password);
	
	Admin loginadmin(String adminEmail, String adminPassword);
	
	void registerAccount(Account account);
	
	void registerVehicle(Vehicle vehicle);
	
	void registerLoan(Loan loan);
	
	List<UserTable> viewAllUsers();  //admin can view all registered users
	
	List<Loan> viewRejectedUsers();

	List<Loan> viewApprovedUsers();

	List<Loan> viewPendingUsers();

//	List<UserTable> viewRejectedUsers();
//
//	List<UserTable> viewApprovedUsers();
//
//	List<UserTable> viewPendingUsers();
	
	
}