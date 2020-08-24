package dao;

import java.util.List;
import model.*;

public interface VehicleDAO
{
	public List<Vehicle> findAll();
	public User findById(int userid);
	public int findByEmailAndPassword(String email, String password);
	public User getUserByEmail(String email);
	public User createUser(User user);
	public User updateUser(int userid, User user);
	public boolean deleteUserById(int userid);

}