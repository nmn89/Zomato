package zomatoapp.rowmapperimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.viewobjects.UserOrderViewObject;

public class UserOrderViewObjectRowMapperImpl implements RowMapper<UserOrderViewObject> {

	public UserOrderViewObject mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserOrderViewObject userOrderViewObject = new UserOrderViewObject();
		userOrderViewObject.setOrderId(rs.getInt("id"));
		userOrderViewObject.setRestaurantName(rs.getString("restaurantName"));
		userOrderViewObject.setDishName(rs.getString("dishName"));
		userOrderViewObject.setDate(rs.getString("date"));
		return userOrderViewObject;
	}

}
