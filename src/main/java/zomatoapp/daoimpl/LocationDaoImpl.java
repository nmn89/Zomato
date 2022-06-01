package zomatoapp.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.LocationDao;
import zomatoapp.model.Location;

@Component
public class LocationDaoImpl implements LocationDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addLocation(Location location) {
		this.hibernateTemplate.saveOrUpdate(location);
	}

	public List<Location> getAllLocations() {
		List<Location> locations = this.hibernateTemplate.loadAll(Location.class);
		return locations;
	}
}