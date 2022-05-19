package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.Order;
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
		String sql = "Select * from Restaurant where location = ?";
		RowMapper<Restaurant> rowMapper = new RestaurantRowMapperImpl();
		List<Restaurant> restaurant = this.jdbcTemplate.query(sql,rowMapper,location);
		return restaurant;
	}

	public Restaurant searchRestaurant(String restaurantName) {
		Restaurant restaurant = this.hibernateTemplate.get(Restaurant.class, restaurantName);
		return restaurant;
	}

	@Transactional
	public void addOrder(Order order) {
		this.hibernateTemplate.saveOrUpdate(order);
	}

	public List<Order> getMyOrder(int uid) {
		String sql = "Select * from Order where uid=?";
		RowMapper<Order> rowMapper = new OrderRowMapperImpl();
		List<Order> order = this.jdbcTemplate.query(sql, rowMapper,uid);
		return order;
	}
}
