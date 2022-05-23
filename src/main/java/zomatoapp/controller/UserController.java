package zomatoapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.UserDao;
import zomatoapp.dao.UserOrderDao;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;
import zomatoapp.model.UserOrder;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping("/register")
	public String userRegister(@ModelAttribute User user,Model m) {
		userDao.createUser(user);
		m.addAttribute("msg", "User Added Successfully");
		return "userLogin";
	}
	
	@RequestMapping("/profile/{userId}")
	public String userProfile(@PathVariable("userId") int userId,Model m) {
		User user = this.userDao.getUser(userId);
		m.addAttribute("profile", user);
		return "userProfile";
	}
	
	@RequestMapping("/delete/{userId}")
	public String userDeletion(@PathVariable("userId") int userId) {
		this.userDao.deleteUser(userId);
		return "userLogin";
	}
	
	@RequestMapping("/restaurants/{locationId}")
	public String viewRestaurant(@PathVariable("locationId") int locationId,Model m) {
		List<Restaurant> restaurant = this.userDao.getRestaurants(locationId);
		m.addAttribute("restaurant",restaurant);
		return "homePage";
	}
	
	@RequestMapping("/restaurant/{restaurantName}")
	public String searchRestaurant(@PathVariable("restaurantName") String rName,Model m) {
		Restaurant restaurant = this.userDao.searchRestaurant(rName);
		m.addAttribute("rname", restaurant);
		return "searchRestaurant";
	}
	
	@RequestMapping("/myorder/{userId}")
	public String showOrder(@PathVariable("userId") int uId,Model m) {
		List<UserOrder> myOrder = this.userDao.getMyOrder(uId);
		m.addAttribute("order", myOrder);
		return "order";
	}
	
	@RequestMapping("/addorder")
	public String addOrder(@ModelAttribute UserOrder userOrder) {
		this.userDao.addOrder(userOrder);
		return "homePage";
	}
}
