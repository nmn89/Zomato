package zomatoapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.Location;

public class LocationRowMapperImpl implements RowMapper<Location>{

	public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
		Location location = new Location();
		location.setLocationId(rs.getInt("locationId"));
		location.setLocation(rs.getString("location"));
		return location;
	}

}
