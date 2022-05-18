package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;

public interface OwnerDao {

	public void createOwner(Owner owner);
	public List<Owner> getAllOwner();
	public void deleteOwner(int oid);
	public Owner getOwner(int oid);
	public List<Restaurant> getMyResaurant(int oid);
	public void addRestaurant(Restaurant restaurant);
	public void deleteRestaurant(int rid);
	public void addDish(Dish dish);
	public void deleteDish(int did);
	public List<Restaurant> getRestaurants(String location);
	public Restaurant searchRestaurant(String restaurantName);
	public List<Dish> searchDish(String dishName);
}
