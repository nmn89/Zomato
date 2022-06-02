package zomatoapp.viewobjects;

public class UserOrderViewObject {
	private int orderId;
	private String dishName;
	private String restaurantName;
	private String date;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public UserOrderViewObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserOrderViewObject(int orderId, String dishName, String restaurantName, String date) {
		super();
		this.orderId = orderId;
		this.dishName = dishName;
		this.restaurantName = restaurantName;
		this.date = date;
	}
	@Override
	public String toString() {
		return "UserOrderViewObject [orderId=" + orderId + ", dishName=" + dishName + ", restaurantName="
				+ restaurantName + ", date=" + date + "]";
	}
	
}
