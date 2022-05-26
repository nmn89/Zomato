package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.Dish;
import zomatoapp.model.Location;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;
import zomatoapp.model.UserOrder;

@Component
public class RestaurantDaoImpl implements RestaurantDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Restaurant getRestaurant(int rid) {
		return this.hibernateTemplate.get(Restaurant.class, rid);
	}

	@Transactional
	public void addDish(Dish dish) {
		this.hibernateTemplate.saveOrUpdate(dish);
	}

	@Transactional
	public void removeDish(int did) {
		Dish dish = this.hibernateTemplate.load(Dish.class,did);
		this.hibernateTemplate.delete(dish);
	}

	public List<Dish> getMyDishes(int rid) {
		String sql="Select * from Dish where rid=?";
		RowMapper<Dish> rowMapper = new DishRowMapperImpl();
		List<Dish> dishes = this.jdbcTemplate.query(sql, rowMapper,rid);
		return dishes;
	}
	
	public List<Restaurant> getRestaurants(int locationId) {
		String sql = "Select * from Restaurant where locatonId = ?";
		RowMapper<Restaurant> rowMapper = new RestaurantRowMapperImpl();
		List<Restaurant> restaurants = this.jdbcTemplate.query(sql,rowMapper,locationId);
		return restaurants;
	}

	public List<Location> getAllLocations() {
		String sql = "Select * from Location";
		RowMapper<Location> rowMapper = new LocationRowMapperImpl();
		List<Location> locations = this.jdbcTemplate.query(sql, rowMapper);
		return locations;
	}

	public List<UserOrder> getRestaurantOrders(int rid) {
		String sql = "Select * from UserOrder where rid=?";
		RowMapper<UserOrder> rowMapper = new UserOrderRowMapperImpl();
		List<UserOrder> userOrders = this.jdbcTemplate.query(sql, rowMapper,rid);
		return userOrders;
	}

}
