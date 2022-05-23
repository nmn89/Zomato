package zomatoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int locationId;
	private String location;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
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
	public Location(int locationId, String location) {
		super();
		this.locationId = locationId;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", location=" + location + "]";
	}
}
