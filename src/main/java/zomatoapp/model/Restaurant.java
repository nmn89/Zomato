package zomatoapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid;
	private String restaurantName;
	private String restaurantLocation;
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
	public String getRestaurantLocation() {
		return restaurantLocation;
	}
	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(int rid, String restaurantName, String restaurantLocation) {
		super();
		this.rid = rid;
		this.restaurantName = restaurantName;
		this.restaurantLocation = restaurantLocation;
	}
	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", restaurantName=" + restaurantName + ", restaurantLocation="
				+ restaurantLocation + "]";
	}
}
