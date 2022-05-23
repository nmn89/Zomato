package zomatoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.RestaurantDao;
import zomatoapp.model.Dish;
import zomatoapp.model.Restaurant;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantDao restaurantDao;
	
	@RequestMapping("/restaurant/{restaurantId}")
	public String getRestaurant(@PathVariable("restaurantId") int rId,Model m) {
		Restaurant restaurant = this.restaurantDao.getRestaurant(rId);
		m.addAttribute("restaurant",restaurant);
		return "myRestaurant";
	}

	@RequestMapping("/Dishes")
	public String addDish(@ModelAttribute Dish dish) {
		this.restaurantDao.addDish(dish);
		return "myDishes";
	}
	
	@RequestMapping("/remove/{dishId}")
	public String removeDish(@PathVariable("dishId") int dId) {
		this.restaurantDao.removeDish(dId);
		return "myDishes";
	}
	
	@RequestMapping("/Dishes/{restaurantId}")
	public String getDish(@PathVariable("restaurantId") int rId,Model m) {
		List<Dish> dishes = this.restaurantDao.getMyDishes(rId);
		m.addAttribute("myDishes", dishes);
		return "myDishes";
	}
}
