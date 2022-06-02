package zomatoapp.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.DishDaoHibernate;
import zomatoapp.model.Dish;

@Component
public class DishDaoHibernateImpl implements DishDaoHibernate{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createDish(Dish dish) {
		this.hibernateTemplate.saveOrUpdate(dish);
	}
	
	public Dish getDish(int dishId) {
		return this.hibernateTemplate.get(Dish.class, dishId);
	}
}
