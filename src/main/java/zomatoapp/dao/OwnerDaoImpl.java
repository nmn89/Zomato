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

@Component
public class OwnerDaoImpl implements OwnerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void createOwner(Owner owner) {
		this.hibernateTemplate.saveOrUpdate(owner);
	}
	
	@Transactional
	public void deleteOwner(int oid) {
		String sql="Delete Owner.*,Restaurant.* from Owner INNER JOIN Restaurant ON Owner.oid=Restaurant.oid where Owner.oid=?";
		this.jdbcTemplate.update(sql,oid);
	}
	
	public Owner getOwner(int oid) {
		return this.hibernateTemplate.get(Owner.class, oid);
	}

	public List<Restaurant> getMyResaurants(int oid) {
		String sql="Select * from Restaurant where oid=?";
		RowMapper<Restaurant> rowMapper = new RestaurantRowMapperImpl();
		List<Restaurant> restaurants = this.jdbcTemplate.query(sql,rowMapper,oid);
		return restaurants;
	}

	@Transactional
	public void addRestaurant(Restaurant restaurant) {
		this.hibernateTemplate.save(restaurant);
	}

	@Transactional
	public void removeRestaurant(int rid) {
		String sql1="Delete from OrderDish where rId=?";
		String sql2="Delete from UserOrder where rid=?";
		String sql3="Delete from Dish where rid=?";
		String sql4="Delete from Restaurant where rid=?";
		this.jdbcTemplate.update(sql1,rid);
		this.jdbcTemplate.update(sql2,rid);
		this.jdbcTemplate.update(sql3,rid);
		this.jdbcTemplate.update(sql4,rid);
	}
	
	public int authenticateOwner(String email,String password) {
		String sql="Select oid from Owner where  email=? and password=?";
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
