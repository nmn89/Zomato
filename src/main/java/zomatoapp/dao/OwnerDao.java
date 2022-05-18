package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Owner;

public interface OwnerDao {

	public void createRestaurant(Owner owner);
	public List<Owner> getAllRestaurant();
	public void deleteRestaurant(int rid);
	public Owner getRestaurant(int rid);
}
