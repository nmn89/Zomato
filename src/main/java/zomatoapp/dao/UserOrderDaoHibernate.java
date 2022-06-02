package zomatoapp.dao;

import zomatoapp.model.UserOrder;

public interface UserOrderDaoHibernate {

	public void addOrder(UserOrder userOrder);
	public UserOrder getOrder(int orderId);
}
