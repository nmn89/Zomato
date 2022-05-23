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
		Owner o = this.hibernateTemplate.load(Owner.class,oid);
		this.hibernateTemplate.delete(o);
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
		Restaurant r = this.hibernateTemplate.load(Restaurant.class,rid);
		this.hibernateTemplate.delete(r);
	}
}
