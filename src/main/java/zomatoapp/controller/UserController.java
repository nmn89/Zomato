package zomatoapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import zomatoapp.dao.UserDao;
import zomatoapp.dao.UserOrderDao;
import zomatoapp.model.Location;
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
	
	@RequestMapping("/userprofile/{userId}")
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
	
	@RequestMapping("/searchrestaurant")
	public String searchRestaurant(@RequestParam("restaurantName") String rName,Model m) {
		Restaurant restaurant = this.userDao.searchRestaurant(rName);
		m.addAttribute("restaurant", restaurant);
		return "searchRestaurant";
	}
	
	@RequestMapping("/getorder/{userId}")
	public String showMyOrders(@PathVariable("userId") int uId,Model m) {
		List<UserOrder> myOrders = this.userDao.getMyOrders(uId);
		m.addAttribute("orders", myOrders);
		m.addAttribute("uid", uId);
		return "userOrder";
	}
	
	@RequestMapping("/userhome")
	public String userHome(@RequestParam("email") String email,@RequestParam("password") String password,Model m) {
		int id = userDao.authenticateUser(email, password);
		if(id!=0) {
			m.addAttribute("uid", id);
			return "userHome";
		}
		else {
			m.addAttribute("msg", "Entered email or password is wrong...");
			return "userLogin";
		}
	}
}
