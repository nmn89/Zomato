package zomatoapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.Order;

public class OrderRowMapperImpl implements RowMapper<Order>{

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order= new Order();
		order.setOrId(rs.getInt("orId"));
		order.setDate(rs.getString("date"));
		order.setRid(rs.getInt("rid"));
		order.setUid(rs.getInt("uid"));
		return order;
	}
}