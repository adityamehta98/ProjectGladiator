package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.UserDAO;
import model.User;

@Repository
public class UserDAOimpl implements UserDAO {

	private EntityManager entityManager;
	@Autowired
    public UserDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;
	}
	@Override
	@Transactional
	public void save(User user) {
		entityManager.merge(user);
	}
	
	@Override
	public User findById(int userid) {
		return entityManager.find(User.class, userid);
	}
	
	@Override
	public List<User> findAll() {
		return entityManager
				.createNamedQuery("fetch-all")
				.getResultList();
	}
	
	@Override
	public int findByEmailAndPassword(String email, String password) {
		return (int) entityManager
				.createQuery("select userid from User where email = :em and password = :pw ")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
	@Override
	public boolean isUserPresent(String email) {
		return (Long)
				entityManager
				.createQuery("select count(c.userid) from User c where c.email = :em ")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}
	@Override
	public void createUser(User ref) {
		// TODO Auto-generated method stub
		
	}
	
}
