package zomatoapp.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.DishDao;
import zomatoapp.model.Dish;

@Component
public class DishDaoImpl implements DishDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void deleteDish(int dishId) {
		String sql1="Delete from OrderDish where dishId=?";
		String sql2="Delete from Dish where id=?";
		this.jdbcTemplate.update(sql1,dishId);
		this.jdbcTemplate.update(sql2,dishId);
	}
	
	
}
