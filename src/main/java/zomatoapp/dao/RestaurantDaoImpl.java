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

	public Restaurant getRestaurant(int rid) {
		return this.hibernateTemplate.get(Restaurant.class, rid);
	}

	public void addDish(Dish dish) {
		// TODO Auto-generated method stub
		
	}

	public void removeDish(int did) {
		// TODO Auto-generated method stub
		
	}

	public List<Dish> getMyDishes(int rid) {
		// TODO Auto-generated method stub
		return null;
	}

}
