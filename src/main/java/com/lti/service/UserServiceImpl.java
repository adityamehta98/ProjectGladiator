package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.model.UserTable;
import com.lti.exception.CustomerServiceException;
import com.lti.repo.RepositoryInterface;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RepositoryInterface repointerface;
	
	@Override
	public void register(UserTable user) {
		if(!repointerface.isUserPresent(user.getUserEmail())) {
			repointerface.registerUser(user);
		}
		else
			throw new CustomerServiceException("User Already Registered");
	}
	
	@Override
	public UserTable login(String userEmail, String password) {
		try {
			if(!repointerface.isUserPresent(userEmail))
				throw new CustomerServiceException("User not registered!");
			
			int id = (int) repointerface.findUserIdByEmailAndPassword(userEmail, password);
			UserTable user = repointerface.findUserByUserID(id);
			return user;
		}
		catch(EmptyResultDataAccessException e) {
			throw new CustomerServiceException("Incorrect Username/Password");
		}
	}
}