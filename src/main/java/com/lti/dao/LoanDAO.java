package com.lti.dao;

import java.util.List;
import com.lti.model.Loan;

public interface LoanDAO {
	
	public void addLoan(Loan loan);
	public List<Loan> retrieveLoan();
	public void removeLoan(int userid);
	public Loan findLoanByUserId(int userid); 
	public Loan findLoanByLoanId(int loanId);
	
}