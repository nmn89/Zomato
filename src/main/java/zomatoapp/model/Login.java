package zomatoapp.model;

public class Login {
	private String mobileNo;
	private String password;
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login() {
		super();
	}
	public Login(String mobileNo, String password) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [mobileNo=" + mobileNo + ", password=" + password + "]";
	}
}
