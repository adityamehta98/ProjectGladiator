package dao;

import java.util.List;
import model.User;

public interface UserDAO
{

	void save(User ref);

	List<User> findAll();

	int findByEmailAndPassword(String email, String password);

	boolean isUserPresent(String email);

	User findById(int userid);

	void createUser(User ref);

}