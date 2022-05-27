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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import zomatoapp.dao.DishDao;
import zomatoapp.dao.RestaurantDao;
import zomatoapp.dao.UserDao;
import zomatoapp.model.Dish;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;
import zomatoapp.model.UserOrder;

@Controller
public class MainController {
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private DishDao dishDao;
	
	@Autowired
	private UserDao userDao;
	
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
	
	@RequestMapping("/addrestaurant/{locationid}/{ownerid}")
	public String createRestaurant(@PathVariable("locationid") int lId,@PathVariable("ownerid") int oId,Model m) {
		System.out.println(lId);
		System.out.println(oId);
		m.addAttribute("lid", lId);
		m.addAttribute("oid", oId);
		return "addRestaurant";
	}
	
	@RequestMapping("/adddish/{rid}")
	public String addDish(@PathVariable("rid") int rId,Model m) {
		m.addAttribute("rid", rId);
		return "addDish";
	}
	
	@RequestMapping("/setorder/{userid}/{restaurantid}/{dishid}")
	public String addOrder(@PathVariable("userid") int uId,@PathVariable("restaurantid") int rId,@PathVariable("dishid") int dId,Model m) {
		m.addAttribute("uid", uId);
		User user = this.userDao.getUser(uId);
		m.addAttribute("user", user.getUserName());
		m.addAttribute("rid", rId);
		Restaurant restaurant = this.restaurantDao.getRestaurant(rId);
		m.addAttribute("restaurant",restaurant.getRestaurantName());
		m.addAttribute("dId", dId);
		Dish dish = this.dishDao.getDish(dId);
		m.addAttribute("dish", dish.getDishName());
		return "addOrder";
	}
}
