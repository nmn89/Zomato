package zomatoapp.viewobjects;

public class UserOrderViewObject {
	private int orderId;
	private String restaurantName;
	private String date;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public UserOrderViewObject(int orderId, String restaurantName, String date) {
		super();
		this.orderId = orderId;
		this.restaurantName = restaurantName;
		this.date = date;
	}
	@Override
	public String toString() {
		return "UserOrderViewObject [orderId=" + orderId + ", restaurantName=" + restaurantName + ", date=" + date
				+ "]";
	}
	
	
}
