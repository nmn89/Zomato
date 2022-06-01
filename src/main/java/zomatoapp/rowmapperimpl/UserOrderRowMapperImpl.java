package zomatoapp.rowmapperimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.UserOrder;

public class UserOrderRowMapperImpl implements RowMapper<UserOrder>{

	public UserOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserOrder userOrder= new UserOrder();
		userOrder.setDate(rs.getString("date"));
		userOrder.setId(rs.getInt("id"));
		userOrder.setUserId(rs.getInt("userId"));
		userOrder.setRestaurantId(rs.getInt("restaurantId"));
		return userOrder;
	}
}