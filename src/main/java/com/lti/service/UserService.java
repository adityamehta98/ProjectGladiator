package com.lti.service;

import com.lti.model.*;

public interface UserService {

	void register(UserTable user);

	UserTable login(String email, String password);
	
	Admin loginadmin(String adminEmail, String adminPassword);
	
	void registerVehicle(Vehicle vehicle);
}