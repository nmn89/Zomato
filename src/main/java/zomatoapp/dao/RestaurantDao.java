package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.Restaurant;

public interface RestaurantDao {

	public Restaurant getRestaurant(int rid);
	public void addDish(Dish dish);
	public void removeDish(int did);
	public List<Dish> getMyDishes(int rid);
}
