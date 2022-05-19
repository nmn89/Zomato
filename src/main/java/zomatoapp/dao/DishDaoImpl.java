package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.Dish;

@Component
public class DishDaoImpl implements DishDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createDish(Dish dish) {
		this.hibernateTemplate.saveOrUpdate(dish);
	}
	
	@Transactional
	public void deleteDish(int did) {
		Dish d = this.hibernateTemplate.load(Dish.class,did);
		this.hibernateTemplate.delete(d);
	}
	
	public Dish getDish(int did) {
		return this.hibernateTemplate.get(Dish.class, did);
	}
}
