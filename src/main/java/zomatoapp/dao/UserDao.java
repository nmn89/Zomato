package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;
import zomatoapp.model.UserOrder;
import zomatoapp.viewobjects.UserOrderViewObject;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;

public interface UserDao {

	public void deleteUser(int userId);
	public Restaurant searchRestaurant(String restaurantName);
	public List<UserOrderViewObject> getMyOrders(int userId);
	public int authenticateUser(String email,String password);
}