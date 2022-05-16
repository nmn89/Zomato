package zomatoapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import zomatoapp.dao.DishDao;
import zomatoapp.dao.RestaurantDao;
import zomatoapp.dao.ZomatoDao;
import zomatoapp.model.Dish;
import zomatoapp.model.Restaurant;
import zomatoapp.model.Zomato;

@Controller
public class MainController {
	
	@Autowired
	private ZomatoDao zomatoDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private DishDao dishDao;
	
	@RequestMapping("/home_restaurant")
	public String showData(Model m) {
		List <Dish> dish= dishDao.getAllDishes();
		m.addAttribute("dish", dish);
		return "/home_restaurant";
	}
	
	@RequestMapping("/")
	public String showHome(Model m) {
		List <Restaurant> restaurant= restaurantDao.getAllRestaurant();
		m.addAttribute("rest", restaurant);
		List <Dish> dish= dishDao.getAllDishes();
		m.addAttribute("menu", dish);
		return "home";
	}
	
	@RequestMapping("/owner")
	public String showOwner() {
		return "owner";
	}
	
	@RequestMapping("/index")
	public String login() {
		return "index";
	}
	
	@RequestMapping("/owner_signup")
	public String ownerSignin() {
		return "owner_signup";
	}
	
	@RequestMapping("/owner_login")
	public String ownerLogin() {
		return "owner_login";
	}
	
	@RequestMapping("/add-user")
	public String addUser() {
		return "registration";
	}
	
	@RequestMapping("/dish")
	public String addDish() {
		return "dish";
	}
	
	@RequestMapping("/add/{dId}")
	public String updateForm(@PathVariable("dId") int did,Model model) {
		Dish dish = this.dishDao.getRestaurant(did);
		model.addAttribute("food", dish);
		return "order";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public RedirectView handleUser(@ModelAttribute Zomato zomato,HttpServletRequest request) {
		this.zomatoDao.createUser(zomato);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/index");
		return redirectView;
	}
	@RequestMapping(value="/owner_login", method=RequestMethod.POST)
	public RedirectView handleRestaurant(@ModelAttribute Restaurant restaurant,HttpServletRequest request) {
		this.restaurantDao.createRestaurant(restaurant);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/owner_login");
		return redirectView;
	}
	@RequestMapping(value="/home_restaurant", method=RequestMethod.POST)
	public RedirectView handleDish(@ModelAttribute Dish dish,HttpServletRequest request) {
		this.dishDao.createDish(dish);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/home_restaurant");
		return redirectView;
	}
	
	
}
