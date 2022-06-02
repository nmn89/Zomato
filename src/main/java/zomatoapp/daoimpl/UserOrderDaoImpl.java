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
	private JdbcTemplate jdbcTemplate;

	public void deleteOrder(int orderId) {
		String sql1="Delete from OrderDish where orderId=?";
		String sql2="Delete from UserOrder where id=?";
		this.jdbcTemplate.update(sql1,orderId);
		this.jdbcTemplate.update(sql2,orderId);
	}
}
