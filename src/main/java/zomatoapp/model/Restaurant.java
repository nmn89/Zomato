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
	private int restaurantName;
	private int restaurantLocation;
	private List<Dish> myDishes;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(int restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getRestaurantLocation() {
		return restaurantLocation;
	}
	public void setRestaurantLocation(int restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}
	public List<Dish> getMyDishes() {
		return myDishes;
	}
	public void setMyDishes(List<Dish> myDishes) {
		this.myDishes = myDishes;
	}
	public Restaurant(int rid, int restaurantName, int restaurantLocation, List<Dish> myDishes) {
		super();
		this.rid = rid;
		this.restaurantName = restaurantName;
		this.restaurantLocation = restaurantLocation;
		this.myDishes = myDishes;
	}
	public Restaurant() {
		super();
	}
	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", restaurantName=" + restaurantName + ", restaurantLocation="
				+ restaurantLocation + ", myDishes=" + myDishes + "]";
	}
	
}
