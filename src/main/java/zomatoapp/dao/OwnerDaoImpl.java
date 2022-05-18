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
public class OwnerDaoImpl implements OwnerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createOwner(Owner owner) {
		this.hibernateTemplate.saveOrUpdate(owner);
	}
	
	public List<Owner> getAllOwner(){
		List <Owner> owner= this.hibernateTemplate.loadAll(Owner.class);
		return owner;
	}
	
	@Transactional
	public void deleteOwner(int oid) {
		Owner o = this.hibernateTemplate.load(Owner.class,oid);
		this.hibernateTemplate.delete(o);
	}
	
	public Owner getOwner(int oid) {
		return this.hibernateTemplate.get(Owner.class, oid);
	}

	public List<Restaurant> getMyResaurant(int oid) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		
	}

	public void removeRestaurant(int rid) {
		// TODO Auto-generated method stub
		
	}

	public void addDish(Dish dish) {
		// TODO Auto-generated method stub
		
	}

	public void removeDish(int did) {
		// TODO Auto-generated method stub
		
	}

	public List<Restaurant> fetchRestaurant(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	public Restaurant searchThisRestaurant(String restaurantName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dish> searchAllDish(String dishName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
