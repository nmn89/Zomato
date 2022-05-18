package zomatoapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import zomatoapp.model.Dish;
import zomatoapp.model.Owner;

@Component
public class OwnerDaoImpl implements OwnerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createRestaurant(Owner owner) {
		this.hibernateTemplate.saveOrUpdate(owner);
	}
	
	public List<Owner> getAllRestaurant(){
		List <Owner> owner= this.hibernateTemplate.loadAll(Owner.class);
		return owner;
	}
	
	@Transactional
	public void deleteRestaurant(int rid) {
		Owner r = this.hibernateTemplate.load(Owner.class,rid);
		this.hibernateTemplate.delete(r);
	}
	
	public Owner getRestaurant(int rid) {
		return this.hibernateTemplate.get(Owner.class, rid);
	}
}
