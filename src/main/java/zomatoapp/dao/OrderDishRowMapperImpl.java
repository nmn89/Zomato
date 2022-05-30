package zomatoapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.OrderDish;

public class OrderDishRowMapperImpl implements RowMapper<OrderDish>{

	public OrderDish mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDish orderDish = new OrderDish();
		orderDish.setOdId(rs.getInt("odId"));
		orderDish.setdId(rs.getInt("dId"));
		orderDish.setDishName(rs.getString("dishName"));
		orderDish.setOrId(rs.getInt("orId"));
		orderDish.setDate(rs.getString("date"));
		orderDish.setQuantity(rs.getString("quantity"));
		orderDish.setuId(rs.getInt("uId"));
		return orderDish;
	}

}
