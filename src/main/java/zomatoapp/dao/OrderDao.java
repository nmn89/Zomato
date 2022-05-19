package zomatoapp.dao;

import zomatoapp.model.Order;

public interface OrderDao {

	public void createOrder(Order order);
	public void deleteOrder(int orid);
	public Order getOrder(int orid);
}
