package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.OrderDish;

public interface OrderDishDao {
	
	public void addOrderDish(OrderDish orderDish);
	public List<OrderDish> getOrderDish(int orId);
	public void deleteOrderDish(int odId);
}
