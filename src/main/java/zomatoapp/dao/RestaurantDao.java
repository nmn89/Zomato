package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.Location;
import zomatoapp.model.Restaurant;
import zomatoapp.model.UserOrder;

public interface RestaurantDao {

	public Restaurant getRestaurant(int rid);
	public void addDish(Dish dish);
	public void removeDish(int did);
	public List<Dish> getMyDishes(int rid);
	public List<Restaurant> getRestaurants(int locationId);
	public List<Location> getAllLocations();
	public List<UserOrder> getRestaurantOrders(int rid);
}
