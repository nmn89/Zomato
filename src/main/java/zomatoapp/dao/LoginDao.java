package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import zomatoapp.model.Login;
import zomatoapp.model.LoginRestaurant;
import zomatoapp.model.Owner;
import zomatoapp.model.User;

@Component
public class LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User validateUser(Login login) {
		String sql = "Select * from User where number='"+login.getMobileNo()+
				     "' and password='"+login.getPassword()+"'";
		List<User> user = jdbcTemplate.query(sql, new RowMapperImpl());
		return user.size()>0?user.get(0):null;
	}
	
	public Owner validateRestaurant(LoginRestaurant login) {
		String sql = "Select * from Restaurant where email='"+login.getEmail()+"' and password='"+login.getPassword()+"'";
		List<Owner> owner = jdbcTemplate.query(sql, new RowMapperRestaurant());
		return owner.size()>0?owner.get(0):null;
	}
	
}
