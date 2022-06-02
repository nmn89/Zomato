package zomatoapp.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.OrderDishDaoHibernate;
import zomatoapp.model.OrderDish;

@Component
public class OrderDishDaoHibernateImpl implements OrderDishDaoHibernate{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addOrderDish(OrderDish orderDish) {
		this.hibernateTemplate.saveOrUpdate(orderDish);
	}

	@Transactional
	public void deleteOrderDish(int orderDishId) {
		OrderDish orderDish= this.hibernateTemplate.get(OrderDish.class,orderDishId);
		this.hibernateTemplate.delete(orderDish);
	}
}
