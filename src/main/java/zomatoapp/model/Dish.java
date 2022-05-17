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
	private String dishPrice;
	private String quantity;
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
	public String getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(String dishPrice) {
		this.dishPrice = dishPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dish(int dId, String dishName, String dishPrice, String quantity) {
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
