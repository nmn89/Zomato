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
	
	@RequestMapping("/showdish/{restaurantId}")
	public String getDishes(@PathVariable("restaurantId") int rId,Model m) {
		List<Dish> dishes = this.restaurantDao.getMyDishes(rId);
		m.addAttribute("dishes", dishes);
		return "restaurantDish";
	}
}
