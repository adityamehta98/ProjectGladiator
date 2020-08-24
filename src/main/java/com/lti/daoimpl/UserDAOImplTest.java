package com.lti.daoimpl;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.dao.UserDAO;
import com.lti.model.User;

public class UserDAOImplTest {

	public static void main(String[] args) {
		System.out.println("We are here");
        UserDAO UserDao = new UserDAOimpl();
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("");  
        EntityManager em=emf.createEntityManager();  
          
em.getTransaction().begin(); 

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
        System.out.println("We are again here!");
        em.persist(l2);
        em.getTransaction().commit();  
        
        emf.close();  
        em.close(); 
	}

}
