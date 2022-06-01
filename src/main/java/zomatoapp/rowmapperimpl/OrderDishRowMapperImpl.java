package zomatoapp.rowmapperimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.OrderDish;

public class OrderDishRowMapperImpl implements RowMapper<OrderDish>{

	public OrderDish mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDish orderDish = new OrderDish();
		orderDish.setId(rs.getInt("id"));
		orderDish.setOrderId(rs.getInt("orderId"));
		orderDish.setDishId(rs.getInt("dishId"));
		orderDish.setQuantity(rs.getString("quantity"));
		return orderDish;
	}

}
