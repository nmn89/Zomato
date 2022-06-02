package zomatoapp.rowmapperimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.viewobjects.RestaurantOrderViewObject;

public class RestaurantOrderViewObjectRowMapperImpl implements RowMapper<RestaurantOrderViewObject>{

	public RestaurantOrderViewObject mapRow(ResultSet rs, int rowNum) throws SQLException {
		RestaurantOrderViewObject restaurantOrderViewObject=new RestaurantOrderViewObject();
		restaurantOrderViewObject.setOrderId(rs.getInt("id"));
		restaurantOrderViewObject.setDishName(rs.getString("dishName"));
		restaurantOrderViewObject.setUserName(rs.getString("userName"));
		restaurantOrderViewObject.setDate(rs.getString("date"));
		return restaurantOrderViewObject;
	}

}
