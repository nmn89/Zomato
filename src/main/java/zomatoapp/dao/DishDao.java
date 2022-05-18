package zomatoapp.dao;

import java.util.List;

import zomatoapp.model.Dish;

public interface DishDao {

	public void createDish(Dish dish);
	public List<Dish> getAllDishes();
	public void deleteDish(int did);
	public Dish getDish(int did);
}
