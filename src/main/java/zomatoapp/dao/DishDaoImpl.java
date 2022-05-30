package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.Dish;

@Component
public class DishDaoImpl implements DishDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void createDish(Dish dish) {
		this.hibernateTemplate.saveOrUpdate(dish);
	}
	
	@Transactional
	public void deleteDish(int did) {
		String sql1="Delete from OrderDish where dId=?";
		String sql2="Delete from Dish where did=?";
		this.jdbcTemplate.update(sql1,did);
		this.jdbcTemplate.update(sql2,did);
	}
	
	public Dish getDish(int did) {
		return this.hibernateTemplate.get(Dish.class, did);
	}
}
