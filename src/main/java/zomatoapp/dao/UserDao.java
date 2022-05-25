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
	public Restaurant searchRestaurant(String restaurantName);
	public List<UserOrder> getMyOrders(int uid);
	public int authenticateUser(String email,String password);
}