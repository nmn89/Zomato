package zomatoapp.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.OrderDishDao;
import zomatoapp.model.OrderDish;
import zomatoapp.rowmapperimpl.OrderDishViewObjectRowMapperImpl;
import zomatoapp.viewobjects.OrderDishesViewObject;

@Component
public class OrderDishDaoImpl implements OrderDishDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<OrderDishesViewObject> getOrderDish(int orderId) {
		String sql="select uo.id,uo.date,r.restaurantName,d.DishName from UserOrder uo INNER JOIN OrderDish od ON uo.id=od.orderId INNER JOIN Dish d ON od.dishId=d\n"
				+ ".id INNER JOIN Restaurant r ON d.restaurantId=r.id AND uo.id=?";
		List<OrderDishesViewObject>  orderDishes=this.jdbcTemplate.query(sql,new OrderDishViewObjectRowMapperImpl() ,orderId);
		return orderDishes;
	}

}
