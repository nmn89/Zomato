package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int oid;
	private String ownerName;
	private String email;
	private long mobileNo;
	private String password;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Owner(int oid, String ownerName, String email, long mobileNo, String password) {
		super();
		this.oid = oid;
		this.ownerName = ownerName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Owner [oid=" + oid + ", ownerName=" + ownerName + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", password=" + password + "]";
	}
}
	
