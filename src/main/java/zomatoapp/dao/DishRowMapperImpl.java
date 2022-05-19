package zomatoapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.Dish;

public class DishRowMapperImpl implements RowMapper<Dish>{

	public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dish dish= new Dish();
		dish.setdId(rs.getInt("dId"));
		dish.setDishName(rs.getString("dishName"));
		dish.setDishPrice(rs.getDouble("dishPrice"));
		dish.setQuantity(rs.getInt("quantity"));
		return dish;
	}

}
