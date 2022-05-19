package zomatoapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.Order;

public class OrderRowMapperImpl implements RowMapper<Order>{

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order= new Order();
		order.setOrId(rs.getInt("orId"));
		order.setDishName(rs.getString("dishName"));
		order.setRestaurantName(rs.getString("restaurantName"));
		order.setDishPrice(rs.getLong("dishPrice"));
		order.setLocation(rs.getString("location"));
		return order;
	}

}
