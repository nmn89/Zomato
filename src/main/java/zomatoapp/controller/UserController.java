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
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/register")
	public String userRegister(@ModelAttribute User user,Model m) {
		userDao.createUser(user);
		m.addAttribute("msg", "User Added Successfully");
		return "login";
	}
	
	@RequestMapping("/profile/{userid}")
	public String userProfile(@PathVariable("userid") int userid,Model m) {
		User user = this.userDao.getUser(userid);
		m.addAttribute("profile", user);
		return "userProfile";
	}
	
	@RequestMapping("/Restaurants/{location}")
	public String viewRestaurant(@PathVariable("location") String location,Model m) {
		List<Restaurant> restaurant = this.userDao.getRestaurants(location);
		m.addAttribute("restaurant",restaurant);
		return "homePage";
	}
}
