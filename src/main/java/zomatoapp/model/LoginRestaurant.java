package zomatoapp.model;

public class LoginRestaurant {

	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginRestaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginRestaurant(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRestaurant [email=" + email + ", password=" + password + "]";
	}
	
	
}
