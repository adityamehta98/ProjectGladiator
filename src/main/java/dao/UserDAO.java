package dao;
//comment
import java.util.List;
import model.User;

public interface UserDAO
{

	void save(User user);

	List<User> findAll();

	int findByEmailAndPassword(String email, String password);

	boolean isUserPresent(String email);

	User findById(int userid);

}