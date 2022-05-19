package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dId;
	private String dishName;
	private double dishPrice;
	private int quantity;
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dish(int dId, String dishName, double dishPrice, int quantity) {
		super();
		this.dId = dId;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Dish [dId=" + dId + ", dishName=" + dishName + ", dishPrice=" + dishPrice + ", quantity=" + quantity
				+ "]";
	}
}
