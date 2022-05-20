package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orId;
	private String date;
	private int  uid;
	private int rid;
	public int getOrId() {
		return orId;
	}
	public void setOrId(int orId) {
		this.orId = orId;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
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
	public UserOrder(int orId, String date, int uid, int rid) {
		super();
		this.orId = orId;
		this.date = date;
		this.uid = uid;
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "Order [orId=" + orId + ", date=" + date + ", uid=" + uid + ", rid=" + rid + "]";
	}
}
