package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.Dish;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;


@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createUser(User user) {
		this.hibernateTemplate.saveOrUpdate(user);
	}
	
	@Transactional
	public void deleteUser(int zid) {
		User z = this.hibernateTemplate.load(User.class,zid);
		this.hibernateTemplate.delete(z);
	}
	
	public User getUser(int zid) {
		return this.hibernateTemplate.get(User.class, zid);
	}
	
	public List<User> getAllUser(){
		List <User> user= this.hibernateTemplate.loadAll(User.class);
		return user;
	}

	public List<Restaurant> getRestaurants(String location) {
		
		return null;
	}

	public Restaurant searchRestaurant(String restaurantName) {
		
		return null;
	}

	public List<Dish> searchDish(String dishName) {
		
		return null;
	}

}
