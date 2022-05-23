package zomatoapp.dao;

import zomatoapp.model.UserOrder;

public interface UserOrderDao {

	public void addOrder(UserOrder userOrder);
	public UserOrder getOrder(int orid);
}