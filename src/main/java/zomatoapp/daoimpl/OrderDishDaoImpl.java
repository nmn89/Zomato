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
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void addOrderDish(OrderDish orderDish) {
		this.hibernateTemplate.saveOrUpdate(orderDish);
	}

	public List<OrderDishesViewObject> getOrderDish(int orderId) {
		String sql="Select od.id,uo.date,r.restaurantName,d.dishName from OrderDish od INNER JOIN UserOrder uo ON od.orderId=uo.id INNER JOIN Restaurant r ON uo.restaurantId=r.id INNER JOIN Dish d ON r.id=d.restaurantId AND od.orderId=?";
		List<OrderDishesViewObject>  orderDishes=this.jdbcTemplate.query(sql,new OrderDishViewObjectRowMapperImpl() ,orderId);
		return orderDishes;
	}

	@Transactional
	public void deleteOrderDish(int orderDishId) {
		OrderDish orderDish= this.hibernateTemplate.get(OrderDish.class,orderDishId);
		this.hibernateTemplate.delete(orderDish);
	}

}
