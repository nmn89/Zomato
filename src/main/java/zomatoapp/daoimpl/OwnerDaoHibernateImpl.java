package zomatoapp.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.dao.OwnerDaoHibernate;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;

@Component
public class OwnerDaoHibernateImpl implements OwnerDaoHibernate{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createOwner(Owner owner) {
		this.hibernateTemplate.saveOrUpdate(owner);
	}
	
	public Owner getOwner(int ownerId) {
		return this.hibernateTemplate.get(Owner.class, ownerId);
	}

	@Transactional
	public void addRestaurant(Restaurant restaurant) {
		this.hibernateTemplate.save(restaurant);
	}
}
