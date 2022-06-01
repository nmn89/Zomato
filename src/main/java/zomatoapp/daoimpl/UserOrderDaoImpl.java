package zomatoapp.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.UserOrderDao;
import zomatoapp.model.UserOrder;

@Component
public class UserOrderDaoImpl implements UserOrderDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void addOrder(UserOrder userOrder) {
		this.hibernateTemplate.saveOrUpdate(userOrder);
	}

	public UserOrder getOrder(int orderId) {
		return this.hibernateTemplate.get(UserOrder.class, orderId);
	}

	@Transactional
	public void deleteOrder(int orderId) {
		String sql1="Delete from OrderDish where orderId=?";
		String sql2="Delete from UserOrder where id=?";
		this.jdbcTemplate.update(sql1,orderId);
		this.jdbcTemplate.update(sql2,orderId);
	}
}
