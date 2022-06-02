package zomatoapp.dao;

import zomatoapp.model.Dish;
import zomatoapp.model.Restaurant;

public interface RestaurantDaoHibernate {

	public Restaurant getRestaurant(int restaurantId);
	public void addDish(Dish dish);
}
