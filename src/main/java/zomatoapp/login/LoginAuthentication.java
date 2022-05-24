package zomatoapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class LoginAuthentication {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int authenticateUser(long mobileNo,String password) {
		String sql="Select uid from User where  number=? and password=?";
		int id = this.jdbcTemplate.queryForObject(sql,Integer.class,mobileNo,password);
		System.out.println(id);
		if(id!=0) {
			return id;
		}
		else {
			return 0;
		}
	}
	
	public int authenticateOwner(String email,String password) {
		String sql="Select oid from Owner where  email=? and password=?";
		int id = this.jdbcTemplate.queryForObject(sql,Integer.class,email,password);
		System.out.println(id);
		if(id!=0) {
			return id;
		}
		else {
			return 0;
		}
	}
}