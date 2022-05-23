package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.Location;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;

public interface OwnerDao {

	public void createOwner(Owner owner);
	public void deleteOwner(int oid);
	public Owner getOwner(int oid);
	public List<Restaurant> getMyResaurant(int oid);
	public void addRestaurant(Restaurant restaurant);
	public void addLocation(Location location);
	public void removeRestaurant(int rid);
}
