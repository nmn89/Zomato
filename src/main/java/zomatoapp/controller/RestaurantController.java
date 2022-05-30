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
import zomatoapp.model.OrderDish;
import zomatoapp.model.Restaurant;
import zomatoapp.model.UserOrder;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantDao restaurantDao;
	
	@RequestMapping("/restaurant/{restaurantid}")
	public String getRestaurant(@PathVariable("restaurantid") int rId,Model m) {
		Restaurant restaurant = this.restaurantDao.getRestaurant(rId);
		m.addAttribute("restaurant",restaurant);
		return "Restaurant";
	}
	
	@RequestMapping("/showlocation/{userid}")
	public String getAllLocations(@PathVariable("userid") int uId,Model m){
		List<Location> locations = restaurantDao.getAllLocations();
		m.addAttribute("locations", locations);
		m.addAttribute("uid", uId);
		return "searchLocation";
	}

	@RequestMapping("/viewrestaurant/{userid}/{locationid}")
	public String viewRestaurants(@PathVariable("userid") int uId,@PathVariable("locationid") int locationId,Model m) {
		List<Restaurant> restaurants = this.restaurantDao.getRestaurants(locationId);
		m.addAttribute("restaurants",restaurants);
		m.addAttribute("uid", uId);
		return "viewRestaurant";
	}
	
	@RequestMapping("/showdish/{restaurantid}")
	public String getDishes(@PathVariable("restaurantid") int rId,Model m) {
		List<Dish> dishes = this.restaurantDao.getMyDishes(rId);
		m.addAttribute("rid", rId);
		m.addAttribute("dishes", dishes);
		return "myRestaurantDish";
	}
	
	@RequestMapping("/showrestaurantdish/{rid}/{uid}/{orid}")
	public String getRestaurantDishes(@PathVariable("rid") int rId,@PathVariable("uid") int uId,@PathVariable("orid") int orId,Model m) {
		List<Dish> dishes = this.restaurantDao.getMyDishes(rId);
		m.addAttribute("dishes", dishes);
		m.addAttribute("uid", uId);
		m.addAttribute("orid", orId);
		return "showRestaurantDish";
	}
	
	@RequestMapping("/showorder/{restaurantid}")
	public String showRestaurantOrders(@PathVariable("restaurantid") int rId,Model m) {
		List<OrderDish> myOrders = this.restaurantDao.getRestaurantOrders(rId);
		m.addAttribute("orders", myOrders);
		return "restaurantOrder";
	}
	
	@RequestMapping("/viewdish/{restaurantid}")
	public String viewDishes(@PathVariable("restaurantid") int rId,Model m) {
		List<Dish> dishes = this.restaurantDao.getMyDishes(rId);
		m.addAttribute("dishes", dishes);
		return "viewRestaurantDish";
	}
}
