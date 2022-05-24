package zomatoapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.Restaurant;

public class RestaurantRowMapperImpl implements RowMapper<Restaurant> {

	public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
		Restaurant rest = new Restaurant();
		rest.setRid(rs.getInt("rid"));
		rest.setRestaurantName(rs.getString("restaurantName"));
		rest.setLocatonId(rs.getInt("locatonId"));
		rest.setOid(rs.getInt("oid"));
		return rest;
	}

}
