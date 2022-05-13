package zomatoapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.Zomato;


@Component
public class ZomatoDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createUser(Zomato zomato) {
		this.hibernateTemplate.saveOrUpdate(zomato);
	}
	
	@Transactional
	public void deleteUser(int zid) {
		Zomato z = this.hibernateTemplate.load(Zomato.class,zid);
		this.hibernateTemplate.delete(z);
	}
	
	public Zomato getUser(int zid) {
		return this.hibernateTemplate.get(Zomato.class, zid);
	}

}
