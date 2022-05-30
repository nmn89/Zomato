package zomatoapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

	public UserOrder getOrder(int orid) {
		return this.hibernateTemplate.get(UserOrder.class, orid);
	}

	@Transactional
	public void deleteOrder(int orid) {
		String sql1="Delete from OrderDish where orId=?";
		String sql2="Delete from UserOrder where orId=?";
		this.jdbcTemplate.update(sql1,orid);
		this.jdbcTemplate.update(sql2,orid);
	}
}
