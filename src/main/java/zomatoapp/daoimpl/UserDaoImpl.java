package zomatoapp.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import zomatoapp.model.UserOrder;
import zomatoapp.rowmapperimpl.RestaurantRowMapperImpl;
import zomatoapp.rowmapperimpl.UserOrderRowMapperImpl;
import zomatoapp.rowmapperimpl.UserOrderViewObjectRowMapperImpl;
import zomatoapp.viewobjects.UserOrderViewObject;
import zomatoapp.dao.UserDao;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;


@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void deleteUser(int userId) {
		String sql1="Delete from UserOrder where userId=?";
		String sql2="Delete from User where id=?";
		this.jdbcTemplate.update(sql1,userId);
		this.jdbcTemplate.update(sql2,userId);
	}

	public Restaurant searchRestaurant(String restaurantName) {
		String sql = "Select * from Restaurant where restaurantName=?";
		RowMapper<Restaurant> rowMapper = new RestaurantRowMapperImpl();
		Restaurant restaurant = this.jdbcTemplate.queryForObject(sql, rowMapper, restaurantName);
		return restaurant;
	}

	public List<UserOrderViewObject> getMyOrders(int userId) {
		String sql = "select uo.id,uo.date,r.restaurantName,d.DishName from UserOrder uo INNER JOIN OrderDish od ON uo.id=od.orderId INNER JOIN Dish d ON od.dishId=d\n"
				+ ".id INNER JOIN Restaurant r ON d.restaurantId=r.id AND uo.userId=?";
		RowMapper<UserOrderViewObject> rowMapper = new UserOrderViewObjectRowMapperImpl();
		List<UserOrderViewObject> userOrders = this.jdbcTemplate.query(sql, rowMapper,userId);
		return userOrders;
	}
	
	public int authenticateUser(String email,String password) {
		String sql="Select id from User where  email=? and password=?";
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
