package zomatoapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.Restaurant;

@Component
public class RestaurantDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createRestaurant(Restaurant restaurant) {
		this.hibernateTemplate.saveOrUpdate(restaurant);
	}
	
	@Transactional
	public void deleteRestaurant(int rid) {
		Restaurant r = this.hibernateTemplate.load(Restaurant.class,rid);
		this.hibernateTemplate.delete(r);
	}
	
	public Restaurant getRestaurant(int rid) {
		return this.hibernateTemplate.get(Restaurant.class, rid);
	}
}
