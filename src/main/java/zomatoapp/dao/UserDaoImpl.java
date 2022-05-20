package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.UserOrder;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;


@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void createUser(User user) {
		this.hibernateTemplate.saveOrUpdate(user);
	}
	
	@Transactional
	public void deleteUser(int uid) {
		User u = this.hibernateTemplate.load(User.class,uid);
		this.hibernateTemplate.delete(u);
	}
	
	public User getUser(int uid) {
		return this.hibernateTemplate.get(User.class, uid);
	}

	public List<Restaurant> getRestaurants(String location) {
		String sql = "Select * from Restaurant where restaurantLocation = ?";
		RowMapper<Restaurant> rowMapper = new RestaurantRowMapperImpl();
		List<Restaurant> restaurant = this.jdbcTemplate.query(sql,rowMapper,location);
		return restaurant;
	}

	public Restaurant searchRestaurant(String restaurantName) {
		String sql = "Select * from Restaurant where restaurantName=?";
		RowMapper<Restaurant> rowMapper = new RestaurantRowMapperImpl();
		Restaurant restaurant = this.jdbcTemplate.queryForObject(sql, rowMapper, restaurantName);
		return restaurant;
	}

	@Transactional
	public void addOrder(UserOrder userOrder) {
		this.hibernateTemplate.saveOrUpdate(userOrder);
	}

	public List<UserOrder> getMyOrder(int uid) {
		String sql = "Select * from UserOrder where uid=?";
		RowMapper<UserOrder> rowMapper = new UserOrderRowMapperImpl();
		List<UserOrder> userOrder = this.jdbcTemplate.query(sql, rowMapper,uid);
		return userOrder;
	}
}
