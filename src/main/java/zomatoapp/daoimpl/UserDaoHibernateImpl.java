package zomatoapp.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.UserDaoHibernate;
import zomatoapp.model.User;

@Component
public class UserDaoHibernateImpl implements UserDaoHibernate{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createUser(User user) {
		this.hibernateTemplate.saveOrUpdate(user);
	}
	
	public User getUser(int userId) {
		return this.hibernateTemplate.get(User.class, userId);
	}
}
