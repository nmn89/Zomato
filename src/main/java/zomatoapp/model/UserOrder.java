package zomatoapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String date;
	private int  userId;
	private int restaurantId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public UserOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserOrder(int id, String date, int userId, int restaurantId) {
		super();
		this.id = id;
		this.date = date;
		this.userId = userId;
		this.restaurantId = restaurantId;
	}
	@Override
	public String toString() {
		return "UserOrder [id=" + id + ", date=" + date + ", userId=" + userId + ", restaurantId=" + restaurantId + "]";
	}
}
