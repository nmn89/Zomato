package zomatoapp.dao;

import zomatoapp.model.OrderDish;

public interface OrderDishDaoHibernate {

	public void addOrderDish(OrderDish orderDish);
	public void deleteOrderDish(int orderDishId);
}
