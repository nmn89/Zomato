package zomatoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.DishDao;
import zomatoapp.dao.OrderDishDao;
import zomatoapp.dao.RestaurantDao;
import zomatoapp.dao.UserDao;
import zomatoapp.model.Dish;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;
import zomatoapp.viewobjects.OrderDishesViewObject;

@Controller
public class MainController {
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private DishDao dishDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDishDao orderDishDao;
	
	@RequestMapping("/")
	public String loginUser() {
		return "userLogin";
	}
	
	@RequestMapping("/registeruser")
	public String registerUser() {
		return "userRegister";
	}
	
	@RequestMapping("/ownerlogin")
	public String loginOwner() {
		return "ownerLogin";
	}
	
	@RequestMapping("/ownerregister")
	public String registerOwner() {
		return "ownerRegister";
	}
	
	@RequestMapping("/addlocation")
	public String addLocation() {
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
		return "addOrder";
	}
	
	@RequestMapping("/setorderdish/{uid}/{rid}/{did}/{orid}")
	public String addOrderDish(@PathVariable("uid") int userId,@PathVariable("rid") int restaurantId,@PathVariable("did") int dishId,@PathVariable("orid") int orderId,Model m) {
		m.addAttribute("orid", orderId);
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