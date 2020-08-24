package com.lti.dao;

import java.util.List;
import com.lti.model.Account;

public interface AccountDAO {
	
	public void addAccount(Account account);
	public List<Account> retrieveAccount();
	public Account findAccountByUserId(int userid);
	public void removeAccount(int userid);
	
}
