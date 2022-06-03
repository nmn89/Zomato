package zomatoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.DishDao;
import zomatoapp.dao.DishDaoHibernate;
import zomatoapp.dao.LocationDao;
import zomatoapp.dao.OrderDishDao;
import zomatoapp.dao.RestaurantDao;
import zomatoapp.dao.RestaurantDaoHibernate;
import zomatoapp.dao.UserDao;
import zomatoapp.model.Dish;
import zomatoapp.model.Location;
import zomatoapp.model.Restaurant;
import zomatoapp.viewobjects.OrderDishesViewObject;

@Controller
public class MainController {
	
	@Autowired
	private DishDaoHibernate dishDaoHibernate;
	
	@Autowired
	private OrderDishDao orderDishDao;
	
	@Autowired
	private LocationDao locationDao;
	
	@Autowired
	private RestaurantDaoHibernate restaurantDaoHibernate;
	
	@RequestMapping("/")
	public String loginUser() {
		return "userLogin";
	}
	
	@RequestMapping("/login")
	public String userLogin(Model m) {
		m.addAttribute("msg", "Entered email or password is wrong...");
		return "userLogin";
	}
	
	@RequestMapping("/registeruser")
	public String registerUser(Model m) {
		List<Location> locations = locationDao.getAllLocations();
		m.addAttribute("locations", locations);
		return "userRegister";
	}
	
	@RequestMapping("/ownerlogin")
	public String loginOwner() {
		return "ownerLogin";
	}
	
	@RequestMapping("/ownerrelogin")
	public String ownerLogin(Model m) {
		m.addAttribute("msg", "Entered email or password is wrong...");
		return "ownerLogin";
	}
	
	@RequestMapping("/ownerregister")
	public String registerOwner() {
		return "ownerRegister";
	}
	
	@RequestMapping("/addlocation/{ownerid}")
	public String addLocation(@PathVariable("ownerid") int ownerId,Model m) {
		m.addAttribute("oid", ownerId);
		return "addLocation";
	}
	
	@RequestMapping("/addrestaurant/{locationid}/{oid}")
	public String createRestaurant(@PathVariable("locationid") int locationId,@PathVariable("oid") int ownerId,Model m) {
		m.addAttribute("lid", locationId);
		m.addAttribute("oid", ownerId);
		return "addRestaurant";
	}
	
	@RequestMapping("/adddish/{rid}")
	public String addDish(@PathVariable("rid") int restaurantId,Model m) {
		m.addAttribute("rid", restaurantId);
		return "addDish";
	}
	
	@RequestMapping("/setrestaurantorder/{rid}/{uid}")
	public String addOrder(@PathVariable("uid") int userId,@PathVariable("rid") int restaurantId,Model m) {
		m.addAttribute("uid", userId);
		m.addAttribute("rid", restaurantId);
		Restaurant restaurant= this.restaurantDaoHibernate.getRestaurant(restaurantId);
		m.addAttribute("restaurant",restaurant.getRestaurantName());
		return "addOrder";
	}
	
	@RequestMapping("/setorderdish/{uid}/{rid}/{did}/{orid}")
	public String addOrderDish(@PathVariable("uid") int userId,@PathVariable("rid") int restaurantId,@PathVariable("did") int dishId,@PathVariable("orid") int orderId,Model m) {
		m.addAttribute("orid", orderId);
		Dish dish= this.dishDaoHibernate.getDish(dishId);
		m.addAttribute("dish", dish.getDishName());
		m.addAttribute("did", dishId);
		m.addAttribute("rid", restaurantId);
		m.addAttribute("uid", userId);
		return "addOrderDish";
	}
	
	@RequestMapping("/successfull/{orid}/{rid}/{uid}")
	public String showCurrentOrder(@PathVariable("uid") int userId,@PathVariable("orid") int orderId,@PathVariable("rid") int restaurantId,Model m) {
		m.addAttribute("orid", orderId);
		m.addAttribute("rid", restaurantId);
		m.addAttribute("uid", userId);
		List<OrderDishesViewObject> orderDishes=this.orderDishDao.getOrderDish(orderId);
		m.addAttribute("orders", orderDishes);
		return "orderDishAdded";
	}
}