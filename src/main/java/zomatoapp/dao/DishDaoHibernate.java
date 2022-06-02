package zomatoapp.dao;

import zomatoapp.model.Dish;

public interface DishDaoHibernate {

	public void createDish(Dish dish);
	public Dish getDish(int dishId);
}
