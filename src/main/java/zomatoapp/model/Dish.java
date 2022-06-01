package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dish {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String dishName;
	private double dishPrice;
	private int restaurantId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}
	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dish(int id, String dishName, double dishPrice, int restaurantId) {
		super();
		this.id = id;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.restaurantId = restaurantId;
	}
	@Override
	public String toString() {
		return "Dish [id=" + id + ", dishName=" + dishName + ", dishPrice=" + dishPrice + ", restaurantId="
				+ restaurantId + "]";
	}
}