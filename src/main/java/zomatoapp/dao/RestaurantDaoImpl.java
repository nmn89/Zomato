package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.Dish;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;

@Component
public class RestaurantDaoImpl implements RestaurantDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void createRestaurant(Restaurant restaurant) {
		this.hibernateTemplate.saveOrUpdate(restaurant);
		
	}

	public List<Restaurant> getAllRestaurant() {
		List <Restaurant> restaurants= this.hibernateTemplate.loadAll(Restaurant.class);
		return restaurants;
	}

	@Transactional
	public void deleteRestaurant(int rid) {
		Restaurant r = this.hibernateTemplate.load(Restaurant.class,rid);
		this.hibernateTemplate.delete(r);
	}

	public Restaurant getRestaurant(int rid) {
		return this.hibernateTemplate.get(Restaurant.class, rid);
	}

	public List<Dish> getDishes(int rid) {
		
		return null;
	}

}
