package zomatoapp.rowmapperimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.User;

public class UserRowMapperImpl implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user= new User();
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("userName"));
		user.setNumber(rs.getLong("number"));
		user.setEmail(rs.getString("email"));
		user.setDefaultLocationId(rs.getInt("defaultLocationId"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
