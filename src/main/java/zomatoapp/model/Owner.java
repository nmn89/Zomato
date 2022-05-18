package zomatoapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int oid;
	private String ownerName;
	private String email;
	private String mobileNo;
	private String password;
	
	private List<Restaurant> myRestaurant;
	private Restaurant restaurant;
	private List<Dish> dish;
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
	public List<Restaurant> getMyRestaurant() {
		return myRestaurant;
	}
	public void setMyRestaurant(List<Restaurant> myRestaurant) {
		this.myRestaurant = myRestaurant;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public List<Dish> getDish() {
		return dish;
	}
	public void setDish(List<Dish> dish) {
		this.dish = dish;
	}
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Owner(int oid, String ownerName, String email, String mobileNo, String password,
			List<Restaurant> myRestaurant, Restaurant restaurant,
			List<Dish> dish) {
		super();
		this.oid = oid;
		this.ownerName = ownerName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.myRestaurant = myRestaurant;
		this.restaurant = restaurant;
		this.dish = dish;
	}
	@Override
	public String toString() {
		return "Owner [oid=" + oid + ", ownerName=" + ownerName + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", password=" + password + ", myRestaurant=" + myRestaurant + ", restaurant=" + restaurant + ", dish=" + dish + "]";
	}
	
}
	
