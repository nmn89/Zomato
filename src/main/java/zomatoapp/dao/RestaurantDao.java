package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.Restaurant;

public interface RestaurantDao {

	public void createRestaurant(Restaurant restaurant);
	public List<Restaurant> getAllRestaurant();
	public void deleteRestaurant(int rid);
	public Restaurant getRestaurant(int rid);
	public List<Dish> getDishes(int rid);
}
