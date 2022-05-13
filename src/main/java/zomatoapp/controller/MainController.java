package zomatoapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import zomatoapp.dao.RestaurantDao;
import zomatoapp.dao.ZomatoDao;
import zomatoapp.model.Restaurant;
import zomatoapp.model.Zomato;

@Controller
public class MainController {
	
	@Autowired
	private ZomatoDao zomatoDao;
	
	private RestaurantDao restaurantDao;
	
	@RequestMapping("/")
	public String showHome() {
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
	
	@RequestMapping("/owner-signup")
	public String ownerSignin() {
		return "owner_signup";
	}
	
	@RequestMapping("/owner-login")
	public String ownerLogin() {
		return "owner_login";
	}
	
	@RequestMapping("/add-user")
	public String add() {
		return "registration";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public RedirectView registerUser(@ModelAttribute Zomato zomato,HttpServletRequest request) {
		this.zomatoDao.createUser(zomato);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/index");
		return redirectView;
	}
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public RedirectView registerRestaurant(@ModelAttribute Restaurant restaurant,HttpServletRequest request) {
		this.restaurantDao.createRestaurant(restaurant);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/owner_login");
		return redirectView;
	}
}
