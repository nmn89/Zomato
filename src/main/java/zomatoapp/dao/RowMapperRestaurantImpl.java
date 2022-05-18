package zomatoapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.Owner;
import zomatoapp.model.User;

public class RowMapperRestaurantImpl implements RowMapper<Owner> {

	public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Owner owner = new Owner();
		owner.setRid(rs.getInt("rid"));
		owner.setEmail(rs.getString("email"));
		owner.setMobileNo(rs.getString("mobileNo"));
		owner.setPassword(rs.getString("password"));
		owner.setRestaurantName(rs.getString("restaurantName"));
		owner.setRestaurantLocation(rs.getString("restaurantLocation"));
		return owner;
	}
}