package zomatoapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.UserOrder;

public class UserOrderRowMapperImpl implements RowMapper<UserOrder>{

	public UserOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserOrder userOrder= new UserOrder();
		userOrder.setOrId(rs.getInt("orId"));
		userOrder.setDate(rs.getString("date"));
		userOrder.setRid(rs.getInt("rid"));
		userOrder.setRestaurantName(rs.getString("restaurantName"));
		userOrder.setDid(rs.getInt("did"));
		userOrder.setDishName(rs.getString("dishName"));
		userOrder.setUid(rs.getInt("uid"));
		userOrder.setUserName(rs.getString("userName"));
		userOrder.setQuantity(rs.getString("quantity"));
		return userOrder;
	}
}