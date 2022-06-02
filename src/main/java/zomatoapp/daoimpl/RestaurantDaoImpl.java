package zomatoapp.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.RestaurantDao;
import zomatoapp.model.Dish;
import zomatoapp.model.Location;
import zomatoapp.model.OrderDish;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;
import zomatoapp.model.UserOrder;
import zomatoapp.rowmapperimpl.DishRowMapperImpl;
import zomatoapp.rowmapperimpl.LocationRowMapperImpl;
import zomatoapp.rowmapperimpl.OrderDishRowMapperImpl;
import zomatoapp.rowmapperimpl.RestaurantOrderViewObjectRowMapperImpl;
import zomatoapp.rowmapperimpl.RestaurantRowMapperImpl;
import zomatoapp.viewobjects.RestaurantOrderViewObject;

@Component
public class RestaurantDaoImpl implements RestaurantDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void removeDish(int dishId) {
		String sql = "DELETE from Dish where id=?";
		this.jdbcTemplate.update(sql,dishId);
	}

	public List<Dish> getMyDishes(int restaurantId) {
		String sql="Select * from Dish where restaurantId=?";
		RowMapper<Dish> rowMapper = new DishRowMapperImpl();
		List<Dish> dishes = this.jdbcTemplate.query(sql, rowMapper,restaurantId);
		return dishes;
	}
	
	public List<Restaurant> getRestaurants(int locationId) {
		String sql = "Select * from Restaurant where locationId = ?";
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

	public List<RestaurantOrderViewObject> getRestaurantOrders(int restaurantId) {
		String sql = "select uo.id,uo.date,d.DishName,u.userName from User u INNER JOIN UserOrder uo ON u.id=uo.userId INNER JOIN OrderDish od ON uo.id=od.orderId INNER JOIN Dish d ON od.dishId=d.id AND uo.restaurantId=?";
		RowMapper<RestaurantOrderViewObject> rowMapper = new RestaurantOrderViewObjectRowMapperImpl();
		List<RestaurantOrderViewObject> orderDish = this.jdbcTemplate.query(sql, rowMapper,restaurantId);
		return orderDish;
	}

}
