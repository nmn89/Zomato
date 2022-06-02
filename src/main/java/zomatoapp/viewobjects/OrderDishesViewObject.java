package zomatoapp.viewobjects;

public class OrderDishesViewObject {
	private Integer orderDishId;
	private String dishName;
	private String restaurantName;
	private String date;
	
	public Integer getOrderDishId() {
		return orderDishId;
	}
	public void setOrderDishId(Integer orderDishId) {
		this.orderDishId = orderDishId;
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
	public OrderDishesViewObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDishesViewObject(Integer orderDishId, String dishName, String restaurantName, String date) {
		super();
		this.orderDishId = orderDishId;
		this.dishName = dishName;
		this.restaurantName = restaurantName;
		this.date = date;
	}
	@Override
	public String toString() {
		return "OrderDishesViewObject [orderDishId=" + orderDishId + ", dishName=" + dishName + ", restaurantName="
				+ restaurantName + ", date=" + date + "]";
	}
}
