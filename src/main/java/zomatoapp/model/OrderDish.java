package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDish {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int dishId;
	private String quantity;
	private int orderId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public OrderDish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDish(int id, int dishId, String quantity, int orderId) {
		super();
		this.id = id;
		this.dishId = dishId;
		this.quantity = quantity;
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "OrderDish [id=" + id + ", dishId=" + dishId + ", quantity=" + quantity + ", orderId=" + orderId + "]";
	}
}
