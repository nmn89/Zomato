package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.UserOrder;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;

public interface UserDao {

	public void createUser(User user);
	public void deleteUser(int uid);
	public User getUser(int uid);
	public List<Restaurant> getRestaurants(int locationId);
	public Restaurant searchRestaurant(String restaurantName);
	public void addOrder(UserOrder userOrder);
	public List<UserOrder> getMyOrder(int uid);
}