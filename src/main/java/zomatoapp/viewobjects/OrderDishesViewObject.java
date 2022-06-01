package zomatoapp.viewobjects;

public class OrderDishesViewObject {
	private Integer odid;
	private String dishName;
	private String restaurantName;
	private String date;
	
	public Integer getOdid() {
		return odid;
	}
	public void setOdid(Integer odid) {
		this.odid = odid;
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
}
