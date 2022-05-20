package zomatoapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.UserOrder;

@Component
public class UserOrderDaoImpl implements UserOrderDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void createOrder(UserOrder userOrder) {
		this.hibernateTemplate.saveOrUpdate(userOrder);
	}

	@Transactional
	public void deleteOrder(int orid) {
		UserOrder o = this.hibernateTemplate.load(UserOrder.class,orid);
		this.hibernateTemplate.delete(o);
	}

	public UserOrder getOrder(int orid) {
		return this.hibernateTemplate.get(UserOrder.class, orid);
	}
}
