package zomatoapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.User;

public class UserRowMapperImpl implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user= new User();
		user.setUid(rs.getInt("uid"));
		user.setUserName(rs.getString("userName"));
		user.setNumber(rs.getLong("number"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
