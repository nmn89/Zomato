package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.User;

public interface UserDao {

	public void createUser(User user);
	public void deleteUser(int zid);
	public User getUser(int zid);
	public List<User> getAllUser();
}
