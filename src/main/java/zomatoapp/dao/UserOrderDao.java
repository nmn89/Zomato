package zomatoapp.dao;

import zomatoapp.model.UserOrder;

public interface UserOrderDao {

	public void createOrder(UserOrder userOrder);
	public void deleteOrder(int orid);
	public UserOrder getOrder(int orid);
}
