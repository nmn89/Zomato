package zomatoapp.rowmapperimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.Dish;

public class DishRowMapperImpl implements RowMapper<Dish>{

	public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dish dish= new Dish();
		dish.setId(rs.getInt("id"));
		dish.setDishName(rs.getString("dishName"));
		dish.setDishPrice(rs.getDouble("dishPrice"));
		dish.setRestaurantId(rs.getInt("restaurantId"));
		return dish;
	}

}
