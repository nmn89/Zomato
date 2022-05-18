package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;

public interface UserDao {

	public void createUser(User user);
	public void deleteUser(int zid);
	public User getUser(int zid);
	public List<User> getAllUser();
	public List<Restaurant> getRestaurants(String location);
	public Restaurant searchRestaurant(String restaurantName);
	public List<Dish> searchDish(String dishName);
}