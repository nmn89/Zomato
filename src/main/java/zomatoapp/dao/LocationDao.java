package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Location;

public interface LocationDao {

	public void addLocation(Location location);
	public List<Location> getAllLocation();
}
