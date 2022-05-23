package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Location;
import zomatoapp.model.Restaurant;

public interface LocationDao {

	public void addLocation(Location location);
	public List<Location> getAllLocations();
}
