package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orId;
	private String dishName;
	private long dishPrice;
	private String restaurantName;
	private String location;
	public int getOrId() {
		return orId;
	}
	public void setOrId(int orId) {
		this.orId = orId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(long dishPrice) {
		this.dishPrice = dishPrice;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orId, String dishName, long dishPrice, String restaurantName, String location) {
		super();
		this.orId = orId;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.restaurantName = restaurantName;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Order [orId=" + orId + ", dishName=" + dishName + ", dishPrice=" + dishPrice + ", restaurantName="
				+ restaurantName + ", location=" + location + "]";
	}
}
