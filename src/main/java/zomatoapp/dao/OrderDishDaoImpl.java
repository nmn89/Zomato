package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.OrderDish;

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

	public List<OrderDish> getOrderDish(int orId) {
		String sql="Select * from OrderDish where orId=?";
		List<OrderDish>  orderDishs=this.jdbcTemplate.query(sql,new OrderDishRowMapperImpl() ,orId);
		return orderDishs;
	}

	@Transactional
	public void deleteOrderDish(int odId) {
		OrderDish orderDish= this.hibernateTemplate.get(OrderDish.class,odId);
		this.hibernateTemplate.delete(orderDish);
	}

}
