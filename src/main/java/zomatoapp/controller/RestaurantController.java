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
import zomatoapp.model.Location;
import zomatoapp.model.Restaurant;
import zomatoapp.model.UserOrder;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantDao restaurantDao;
	
	@RequestMapping("/restaurant/{restaurantId}")
	public String getRestaurant(@PathVariable("restaurantId") int rId,Model m) {
		Restaurant restaurant = this.restaurantDao.getRestaurant(rId);
		m.addAttribute("restaurant",restaurant);
		return "Restaurant";
	}
	
	@RequestMapping("/showlocation/{userId}")
	public String getAllLocations(@PathVariable("userId") int uid,Model m){
		List<Location> locations = restaurantDao.getAllLocations();
		m.addAttribute("locations", locations);
		m.addAttribute("uid", uid);
		return "searchLocation";
	}

	@RequestMapping("/viewrestaurant/{userId}/{locationId}")
	public String viewRestaurants(@PathVariable("userId") int uid,@PathVariable("locationId") int locationId,Model m) {
		List<Restaurant> restaurants = this.restaurantDao.getRestaurants(locationId);
		m.addAttribute("restaurants",restaurants);
		m.addAttribute("uid", uid);
		return "viewRestaurant";
	}
	
	@RequestMapping("/showdish/{restaurantid}")
	public String getDishes(@PathVariable("restaurantid") int rId,Model m) {
		List<Dish> dishes = this.restaurantDao.getMyDishes(rId);
		m.addAttribute("dishes", dishes);
		return "myRestaurantDish";
	}
	
	@RequestMapping("/showrestaurantdish/{rid}/{uid}")
	public String getRestaurantDishes(@PathVariable("rid") int rid,@PathVariable("uid") int uid,Model m) {
		List<Dish> dishes = this.restaurantDao.getMyDishes(rid);
		m.addAttribute("dishes", dishes);
		m.addAttribute("uid", uid);
		return "showRestaurantDish";
	}
	
	@RequestMapping("/showorder/{restaurantid}")
	public String showRestaurantOrders(@PathVariable("restaurantid") int rid,Model m) {
		List<UserOrder> myOrders = this.restaurantDao.getRestaurantOrders(rid);
		m.addAttribute("orders", myOrders);
		return "restaurantOrder";
	}
}
