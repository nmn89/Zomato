package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.Location;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;

public interface OwnerDao {

	public void createOwner(Owner owner);
	public void deleteOwner(int ownerId);
	public Owner getOwner(int ownerId);
	public List<Restaurant> getMyResaurants(int ownerId);
	public void addRestaurant(Restaurant restaurant);
	public void removeRestaurant(int restaurantId);
	public int authenticateOwner(String email,String password);
}
