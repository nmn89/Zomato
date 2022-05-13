package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zomato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userName;
	private String email;
	private String number;
	private String password;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Zomato(String userName, String email, String number, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.number = number;
		this.password = password;
	}
	public Zomato() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Zomato [id=" + id + ", userName=" + userName + ", email=" + email + ", number=" + number + ", password="
				+ password + "]";
	} 	
	
	
}
