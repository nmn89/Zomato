package zomatoapp.rowmapperimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.Location;

public class LocationRowMapperImpl implements RowMapper<Location>{

	public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
		Location location = new Location();
		location.setId(rs.getInt("id"));
		location.setLocation(rs.getString("location"));
		return location;
	}

}
