package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location(int id, String location) {
		super();
		this.id = id;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", location=" + location + "]";
	}
}
