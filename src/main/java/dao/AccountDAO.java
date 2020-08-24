package dao;

import java.util.List;
import model.Account;

public interface AccountDAO {
	
	void addAccount(Account account);
	
	List<Account> retrieveAccount();
	
	Account findAccountByUserId(int userid);
	
	void removeAccount(int userid);
	
}
