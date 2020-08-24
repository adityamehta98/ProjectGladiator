package com.lti;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.lti.model.User;
import com.lti.dao.UserDAO;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class ApplicationTest {

	@Autowired
	private UserDAO userDAO;
	
	@Test
	void add() {
		User user1 =new User();
		user1.setName("Gajendra");
		user1.setAge(23);
		user1.setGender("Male");
		user1.setAddress("Jhansi U.P.");
		user1.setDob(LocalDate.of(1997, 06, 06));
		user1.setPassword("Oracle_321");
		user1.setCity("Lalitpur");
		user1.setZip(284405);	
		userDAO.save(user1);
	}
}