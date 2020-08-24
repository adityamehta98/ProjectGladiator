package dao;

import java.util.List;
import model.Loan;

public interface LoanDAO {
	
	public void addLoan(Loan loan);
	public List<Loan> retrieveLoan();
	public void removeLoan(int userid);
	public Loan findLoanByUserId(int userid); 
	public Loan findLoanByLoanId(int loanId);
	
}