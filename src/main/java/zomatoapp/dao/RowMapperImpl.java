package zomatoapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.User;

public class RowMapperImpl implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setNumber(rs.getString("number"));
		user.setPassword(rs.getString("password"));
		user.setUserName(rs.getString("userName"));
		return user;
	}
	
}
