package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import zomatoapp.model.Location;

@Component
public class LocationDaoImpl implements LocationDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addLocation(Location location) {
		this.hibernateTemplate.saveOrUpdate(location);
	}

	public List<Location> getAllLocation() {
		String sql = "Select * from Location";
		RowMapper<Location> rowMapper = new LocationRowMapperImpl();
		List<Location> location = this.jdbcTemplate.query(sql, rowMapper);
		return location;
	}

}
