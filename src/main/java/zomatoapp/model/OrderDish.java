package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDish {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int odId;
	private String date;
	private int uId;
	private int rId;
	private int dId;
	private String dishName;
	private String quantity;
	private int orId;
	public int getOdId() {
		return odId;
	}
	public void setOdId(int odId) {
		this.odId = odId;
	}
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
	public int getOrId() {
		return orId;
	}
	public void setOrId(int orId) {
		this.orId = orId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public OrderDish(int odId, String date, int uId, int rId, int dId, String dishName, String quantity, int orId) {
		super();
		this.odId = odId;
		this.date = date;
		this.uId = uId;
		this.rId = rId;
		this.dId = dId;
		this.dishName = dishName;
		this.quantity = quantity;
		this.orId = orId;
	}
	@Override
	public String toString() {
		return "OrderDish [odId=" + odId + ", date=" + date + ", uId=" + uId + ", rId=" + rId + ", dId=" + dId
				+ ", dishName=" + dishName + ", quantity=" + quantity + ", orId=" + orId + "]";
	}
}
