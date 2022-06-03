package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String email;
	private long number;
	private String password;
	private int defaultLocationId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDefaultLocationId() {
		return defaultLocationId;
	}
	public void setDefaultLocationId(int defaultLocationId) {
		this.defaultLocationId = defaultLocationId;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName, String email, long number, String password, int defaultLocationId) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.number = number;
		this.password = password;
		this.defaultLocationId = defaultLocationId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", number=" + number + ", password="
				+ password + ", defaultLocationId=" + defaultLocationId + "]";
	}
}
