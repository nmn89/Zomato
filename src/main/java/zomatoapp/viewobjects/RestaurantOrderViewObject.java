package zomatoapp.viewobjects;

public class RestaurantOrderViewObject {

	private int orderId;
	private String dishName;
	private String userName;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public RestaurantOrderViewObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantOrderViewObject(int orderId, String dishName, String userName, String date) {
		super();
		this.orderId = orderId;
		this.dishName = dishName;
		this.userName = userName;
		this.date = date;
	}
	@Override
	public String toString() {
		return "RestaurantOrderViewObject [orderId=" + orderId + ", dishName=" + dishName + ", userName=" + userName
				+ ", date=" + date + "]";
	}
	
}
