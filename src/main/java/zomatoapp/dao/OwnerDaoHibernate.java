package zomatoapp.dao;

import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;

public interface OwnerDaoHibernate {

	public void createOwner(Owner owner);
	public Owner getOwner(int ownerId);
	public void addRestaurant(Restaurant restaurant);
}
