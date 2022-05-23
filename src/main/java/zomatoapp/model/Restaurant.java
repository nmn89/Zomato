package zomatoapp.model;

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
	private int locatonId;
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
	public int getLocatonId() {
		return locatonId;
	}
	public void setLocatonId(int locatonId) {
		this.locatonId = locatonId;
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
	public Restaurant(int rid, String restaurantName, int locatonId, int oid) {
		super();
		this.rid = rid;
		this.restaurantName = restaurantName;
		this.locatonId = locatonId;
		this.oid = oid;
	}
	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", restaurantName=" + restaurantName + ", locatonId=" + locatonId + ", oid="
				+ oid + "]";
	}
}
