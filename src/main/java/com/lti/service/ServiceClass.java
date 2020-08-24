package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.exception.CustomerServiceException;
import com.lti.model.*;
import com.lti.repo.RepositoryInterface;

@Service
public class ServiceClass implements ServiceInterface {

	@Autowired
	private RepositoryInterface repo;

	@Override
	public long registerUser(UserTable user) {
		return repo.registerUser(user);
	}

	@Override
	public long registerAdmin(Admin admin) {
		return repo.registerAdmin(admin);
	}

	@Override
	public String registerAccount(Account account) {
		return repo.registerAccount(account);
	}

	@Override
	public long registerLoan(Loan loan) {
		return repo.registerLoan(loan);
	}

	@Override
	public long registerVehicle(Vehicle vehicle) {
		return repo.registerVehicle(vehicle);
	}

	
}
