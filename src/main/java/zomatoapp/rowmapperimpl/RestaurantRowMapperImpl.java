package zomatoapp.rowmapperimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.Restaurant;

public class RestaurantRowMapperImpl implements RowMapper<Restaurant> {

	public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
		Restaurant rest = new Restaurant();
		rest.setId(rs.getInt("id"));
		rest.setRestaurantName(rs.getString("restaurantName"));
		rest.setLocationId(rs.getInt("locationId"));
		rest.setOwnerId(rs.getInt("ownerId"));
		return rest;
	}
}