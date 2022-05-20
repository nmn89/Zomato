package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
	@Id
	private int rid;
	private String restaurantName;
	private String restaurantLocation;
	private int oid;
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
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(int rid, String restaurantName, String restaurantLocation, int oid) {
		super();
		this.rid = rid;
		this.restaurantName = restaurantName;
		this.restaurantLocation = restaurantLocation;
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", restaurantName=" + restaurantName + ", restaurantLocation="
				+ restaurantLocation + ", oid=" + oid + "]";
	}
}
