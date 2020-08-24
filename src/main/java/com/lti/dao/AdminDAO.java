package com.lti.dao;

import java.util.List;

import com.lti.model.*;

public interface AdminDAO
{
	public List<Admin> findAll();
	public User findById(int userid);
	public Loan findByLoanId(int loanId);
	public Loan findRejectList(String applicationStatus);
	public User createAdmin(Admin admin);
	public boolean deleteUserById(int userid);

}