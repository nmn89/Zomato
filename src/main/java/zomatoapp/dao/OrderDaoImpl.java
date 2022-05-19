package zomatoapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.Order;

@Component
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void createOrder(Order order) {
		this.hibernateTemplate.saveOrUpdate(order);
	}

	@Transactional
	public void deleteOrder(int orid) {
		Order o = this.hibernateTemplate.load(Order.class,orid);
		this.hibernateTemplate.delete(o);
	}

	public Order getOrder(int orid) {
		return this.hibernateTemplate.get(Order.class, orid);
	}
}
