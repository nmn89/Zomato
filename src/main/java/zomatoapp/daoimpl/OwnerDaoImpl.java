package zomatoapp.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.OwnerDao;
import zomatoapp.model.Dish;
import zomatoapp.model.Location;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;
import zomatoapp.rowmapperimpl.RestaurantRowMapperImpl;

@Component
public class OwnerDaoImpl implements OwnerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void deleteOwner(int ownerId) {
		String sql1="Delete Restaurant.*,Dish.* from Restaurant INNER JOIN Dish\n"
				+" ON Restaurant.id=Dish.restaurantId AND Restaurant.ownerId=?";
		String sql2="DELETE from Restaurant where ownerId=?";
		String sql3="DELETE from Owner where id=?";
		this.jdbcTemplate.update(sql1,ownerId);
		this.jdbcTemplate.update(sql2,ownerId);
		this.jdbcTemplate.update(sql3,ownerId);
	}

	public List<Restaurant> getMyResaurants(int ownerId) {
		String sql="Select * from Restaurant where ownerId=?";
		RowMapper<Restaurant> rowMapper = new RestaurantRowMapperImpl();
		List<Restaurant> restaurants = this.jdbcTemplate.query(sql,rowMapper,ownerId);
		return restaurants;
	}

	@Transactional
	public void removeRestaurant(int restaurantId) {
		String sql1="Delete from UserOrder where restaurantId=?";
		String sql2="Delete from Dish where restaurantId=?";
		String sql3="Delete from Restaurant where id=?";
		this.jdbcTemplate.update(sql1,restaurantId);
		this.jdbcTemplate.update(sql2,restaurantId);
		this.jdbcTemplate.update(sql3,restaurantId);
	}
	
	public int authenticateOwner(String email,String password) {
		String sql="Select id from Owner where  email=? and password=?";
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
