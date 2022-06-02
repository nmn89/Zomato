package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.OrderDish;
import zomatoapp.viewobjects.OrderDishesViewObject;

public interface OrderDishDao {
	
	public List<OrderDishesViewObject> getOrderDish(int orderId);
}
