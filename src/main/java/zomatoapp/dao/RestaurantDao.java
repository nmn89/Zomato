package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.Location;
import zomatoapp.model.OrderDish;
import zomatoapp.model.Restaurant;
import zomatoapp.model.UserOrder;
import zomatoapp.viewobjects.RestaurantOrderViewObject;

public interface RestaurantDao {

	public Restaurant getRestaurant(int restaurantId);
	public void addDish(Dish dish);
	public void removeDish(int dishId);
	public List<Dish> getMyDishes(int restaurantId);
	public List<Restaurant> getRestaurants(int locationId);
	public List<Location> getAllLocations();
	public List<RestaurantOrderViewObject> getRestaurantOrders(int restaurantId);
}
