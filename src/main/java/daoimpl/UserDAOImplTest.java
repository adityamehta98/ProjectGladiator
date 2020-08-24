package daoimpl;

import java.sql.Date;

import dao.UserDAO;
import model.User;

public class UserDAOImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        UserDAO UserDao = new UserDAOimpl();
        
        
        User l2 = new User();
        l2.setUserid(1000);
        l2.setName("Aditya");
        l2.setAge(23);
        l2.setGender("Male");
        l2.setAddress("221B, Bakers Street");
        l2.setEmail("me@sherlock.com");
        l2.setPassword("123456tf");
        l2.setDob(Date.valueOf("1998-7-22")); //YYYY-MM-DD
        l2.setCity("Jaipur");
        l2.setZip(302001);
        UserDao.createUser(l2);

	}

}
