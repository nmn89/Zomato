package zomatoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zomatoapp.dao.RestaurantDao;
import zomatoapp.dao.RestaurantDaoHibernate;
import zomatoapp.model.Dish;
import zomatoapp.model.Location;
import zomatoapp.model.Restaurant;
import zomatoapp.viewobjects.RestaurantOrderViewObject;

import org.json.JSONString;
import org.json.simple.*;

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
	public String userHomePage(@PathVariable("uid") int userId,@PathVariable("locationid") int locationId,Model m) {
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
		Restaurant restaurant = this.restaurantDaoHibernate.getRestaurant(restaurantId);
		m.addAttribute("restaurant", restaurant);
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
		Restaurant restaurant = this.restaurantDaoHibernate.getRestaurant(restaurantId);
		m.addAttribute("rname", restaurant.getRestaurantName());
		m.addAttribute("orders", myOrders);
		return "restaurantOrder";
	}
	
	@RequestMapping(value="/viewdish/{id}",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public String viewDishes(@PathVariable("id") int restaurantId,Model m) {
		System.out.println(restaurantId);
		List<Dish> dishes = this.restaurantDao.getMyDishes(restaurantId);
		JSONObject obj = new JSONObject();
		for(int i=1;i<=dishes.size();i++) {
			Dish dish = dishes.get(i-1);
			String key = dish.getDishName();
			String value = Double.toString(dish.getDishPrice());
			obj.put(key, value);
		}
		String data = obj.toJSONString();
		System.out.println(data);
		return data;
	}
}
