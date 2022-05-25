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

	public Restaurant searchRestaurant(String restaurantName) {
		String sql = "Select * from Restaurant where restaurantName=?";
		RowMapper<Restaurant> rowMapper = new RestaurantRowMapperImpl();
		Restaurant restaurant = this.jdbcTemplate.queryForObject(sql, rowMapper, restaurantName);
		return restaurant;
	}

	public List<UserOrder> getMyOrders(int uid) {
		String sql = "Select * from UserOrder where uid=?";
		RowMapper<UserOrder> rowMapper = new UserOrderRowMapperImpl();
		List<UserOrder> userOrders = this.jdbcTemplate.query(sql, rowMapper,uid);
		return userOrders;
	}
	
	public int authenticateUser(String email,String password) {
		String sql="Select uid from User where  email=? and password=?";
		try {
			int id = this.jdbcTemplate.queryForObject(sql,Integer.class,email,password);
			System.out.println(id);
			if(id!=0) {
				return id;
			}
			else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}
}
