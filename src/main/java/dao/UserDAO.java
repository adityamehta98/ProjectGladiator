package dao;

import java.util.List;
import model.User;

public interface UserDAO
{
	public List<User> findAll();
	public User findById(int userid);
	public int findByEmailAndPassword(String email, String password);
	public User getUserByEmail(String email);
	public User createUser(User user);
	public User updateUser(int userid, User user);
	public boolean deleteUserById(int userid);

}

