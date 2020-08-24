package com.lti.dao;

import java.util.List;
import com.lti.model.User;

public interface UserDAO
{
	void save(User user);
	
	
	
	public List<User> findAll();
	public User findById(int userid);
	public int findByEmailAndPassword(String email, String password);
	public User getUserByEmail(String email);
	public User createUser(User user);
	public User updateUser(int userid, User user);
	public boolean deleteUserById(int userid);

}

