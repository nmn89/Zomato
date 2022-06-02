package zomatoapp.dao;

import zomatoapp.model.User;

public interface UserDaoHibernate {
	
	public void createUser(User user);
	public User getUser(int userId);
}
