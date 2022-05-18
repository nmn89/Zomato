package zomatoapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uid;
	private String userName;
	private String email;
	private String number;
	private String password;
	
	private String restaurant;
	private List<Restaurant> allRestaurant;
	private List<Dish> dish;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public List<Restaurant> getAllRestaurant() {
		return allRestaurant;
	}
	public void setAllRestaurant(List<Restaurant> allRestaurant) {
		this.allRestaurant = allRestaurant;
	}
	public List<Dish> getDish() {
		return dish;
	}
	public void setDish(List<Dish> dish) {
		this.dish = dish;
	}
	public User(int uid, String userName, String email, String number, String password, String restaurant,
			List<Restaurant> allRestaurant, List<Dish> dish) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.email = email;
		this.number = number;
		this.password = password;
		this.restaurant = restaurant;
		this.allRestaurant = allRestaurant;
		this.dish = dish;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", email=" + email + ", number=" + number + ", password="
				+ password + ", restaurant=" + restaurant + ", allRestaurant=" + allRestaurant + ", dish=" + dish + "]";
	}
}
