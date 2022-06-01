package zomatoapp.rowmapperimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.viewobjects.OrderDishesViewObject;

public class OrderDishViewObjectRowMapperImpl implements RowMapper<OrderDishesViewObject> {


	public OrderDishesViewObject mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDishesViewObject orderDishesViewObject= new OrderDishesViewObject();
		orderDishesViewObject.setOdid(rs.getInt("odid"));
		orderDishesViewObject.setRestaurantName(rs.getString("restaurantName"));
		orderDishesViewObject.setDishName(rs.getString("dishName"));
		orderDishesViewObject.setDate(rs.getString("date"));
		return orderDishesViewObject;
	}
}