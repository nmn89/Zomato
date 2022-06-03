package zomatoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.RestaurantDao;
import zomatoapp.dao.RestaurantDaoHibernate;
import zomatoapp.model.Dish;
import zomatoapp.model.Location;
import zomatoapp.model.Restaurant;
import zomatoapp.viewobjects.RestaurantOrderViewObject;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private RestaurantDaoHibernate restaurantDaoHibernate;
	
	@RequestMapping("/restaurant/{rid}")
	public String getRestaurant(@PathVariable("rid") int restaurantId,Model m) {
		Restaurant restaurant = this.restaurantDaoHibernate.getRestaurant(restaurantId);
		m.addAttribute("restaurant",restaurant);
		return "Restaurant";
	}
	
	@RequestMapping("/showlocation/{uid}")
	public String getAllLocations(@PathVariable("uid") int userId,Model m){
		List<Location> locations = restaurantDao.getAllLocations();
		m.addAttribute("locations", locations);
		m.addAttribute("uid", userId);
		return "searchLocation";
	}

	@RequestMapping("/userhome/{uid}/{locationid}")
	public String homePage(@PathVariable("uid") int userId,@PathVariable("locationid") int locationId,Model m) {
		List<Restaurant> restaurants = this.restaurantDao.getRestaurants(locationId);
		m.addAttribute("restaurants",restaurants);
		List<Location> locations = restaurantDao.getAllLocations();
		m.addAttribute("locations", locations);
		m.addAttribute("uid", userId);
		return "userHome";
	}
	
	@RequestMapping("/showdish/{rid}")
	public String getDishes(@PathVariable("rid") int restaurantId,Model m) {
		List<Dish> dishes = this.restaurantDao.getMyDishes(restaurantId);
		m.addAttribute("rid", restaurantId);
		m.addAttribute("dishes", dishes);
		return "myRestaurantDish";
	}
	
	@RequestMapping("/showrestaurantdish/{rid}/{uid}/{orid}")
	public String getRestaurantDishes(@PathVariable("rid") int restaurantId,@PathVariable("uid") int userId,@PathVariable("orid") int orderId,Model m) {
		List<Dish> dishes = this.restaurantDao.getMyDishes(restaurantId);
		m.addAttribute("dishes", dishes);
		m.addAttribute("uid", userId);
		m.addAttribute("orid", orderId);
		return "showRestaurantDish";
	}
	
	@RequestMapping("/showorder/{rid}")
	public String showRestaurantOrders(@PathVariable("rid") int restaurantId,Model m) {
		List<RestaurantOrderViewObject> myOrders = this.restaurantDao.getRestaurantOrders(restaurantId);
		m.addAttribute("orders", myOrders);
		return "restaurantOrder";
	}
	
	@RequestMapping("/viewdish/{rid}")
	public String viewDishes(@PathVariable("rid") int restaurantId,Model m) {
		List<Dish> dishes = this.restaurantDao.getMyDishes(restaurantId);
		m.addAttribute("dishes", dishes);
		return "viewRestaurantDish";
	}
}
