package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orId;
	private String date;
	private int  uid;
	private String userName;
	private int rid;
	private String restaurantName;
	private int did;
	private String dishName;
	private String quantity;
	public int getOrId() {
		return orId;
	}
	public void setOrId(int orId) {
		this.orId = orId;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public UserOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserOrder(int orId, String date, int uid, String userName, int rid, String restaurantName, int did,
			String dishName, String quantity) {
		super();
		this.orId = orId;
		this.date = date;
		this.uid = uid;
		this.userName = userName;
		this.rid = rid;
		this.restaurantName = restaurantName;
		this.did = did;
		this.dishName = dishName;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "UserOrder [orId=" + orId + ", date=" + date + ", uid=" + uid + ", userName=" + userName + ", rid=" + rid
				+ ", restaurantName=" + restaurantName + ", did=" + did + ", dishName=" + dishName + ", quantity="
				+ quantity + "]";
	}
	
}
