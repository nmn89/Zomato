package zomatoapp.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.RestaurantDaoHibernate;
import zomatoapp.model.Dish;
import zomatoapp.model.Restaurant;

@Component
public class RestaurantDaoHibernateImpl implements RestaurantDaoHibernate{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Restaurant getRestaurant(int restaurantId) {
		return this.hibernateTemplate.get(Restaurant.class, restaurantId);
	}

	@Transactional
	public void addDish(Dish dish) {
		this.hibernateTemplate.saveOrUpdate(dish);
	}
}
