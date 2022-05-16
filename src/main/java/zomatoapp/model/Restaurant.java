package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rid;
	private String restaurantName;
	private String email;
	private String mobileNo;
	private String password;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(int rid, String restaurantName, String email, String mobileNo, String password) {
		super();
		this.rid = rid;
		this.restaurantName = restaurantName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Restaurant [id=" + rid + ", restaurantName=" + restaurantName + ", email=" + email + ", mobileNo="
				+ mobileNo + ", password=" + password + "]";
	}
	
}
