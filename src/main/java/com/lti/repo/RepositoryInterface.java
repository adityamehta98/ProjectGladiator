package com.lti.repo;

import java.util.List;

import com.lti.model.*;

public interface RepositoryInterface {

	//User
	public long registerUser(UserTable user);
	
	//Admin
	public long registerAdmin(Admin admin);
	
	//Account
	public String registerAccount(Account account);
	
	//Loan
	public long registerLoan(Loan loan);
	
	//Vehicle
	public long registerVehicle(Vehicle vehicle);
	
}
