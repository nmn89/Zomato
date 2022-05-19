package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.Order;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;

public interface UserDao {

	public void createUser(User user);
	public void deleteUser(int uid);
	public User getUser(int uid);
	public List<Restaurant> getRestaurants(String location);
	public Restaurant searchRestaurant(String restaurantName);
	public void addOrder(Order order);
	public List<Order> getMyOrder(int uid);
}