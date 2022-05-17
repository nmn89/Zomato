package zomatoapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.User;


@Component
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createUser(User user) {
		this.hibernateTemplate.saveOrUpdate(user);
	}
	
	@Transactional
	public void deleteUser(int zid) {
		User z = this.hibernateTemplate.load(User.class,zid);
		this.hibernateTemplate.delete(z);
	}
	
	public User getUser(int zid) {
		return this.hibernateTemplate.get(User.class, zid);
	}

}
