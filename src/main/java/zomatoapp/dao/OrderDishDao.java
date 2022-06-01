package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.OrderDish;
import zomatoapp.viewobjects.OrderDishesViewObject;

public interface OrderDishDao {
	
	public void addOrderDish(OrderDish orderDish);
	public List<OrderDishesViewObject> getOrderDish(int orderId);
	public void deleteOrderDish(int orderDishId);
}
