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
import org.springframework.web.servlet.view.RedirectView;

import zomatoapp.dao.UserDao;
import zomatoapp.dao.UserOrderDao;
import zomatoapp.model.Location;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;
import zomatoapp.model.UserOrder;
import zomatoapp.viewobjects.UserOrderViewObject;

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
	
	@RequestMapping("/userprofile/{uid}")
	public String userProfile(@PathVariable("uid") int userId,Model m) {
		User user = this.userDao.getUser(userId);
		m.addAttribute("profile", user);
		return "userProfile";
	}
	
	@RequestMapping("/deleteuser/{uid}")
	public RedirectView userDeletion(@PathVariable("uid") int userId,HttpServletRequest request) {
		this.userDao.deleteUser(userId);
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/searchrestaurant")
	public String searchRestaurant(@RequestParam("restaurantName") String rName,Model m) {
		Restaurant restaurant = this.userDao.searchRestaurant(rName);
		m.addAttribute("restaurant", restaurant);
		return "searchRestaurant";
	}
	
	@RequestMapping("/getorder/{uid}")
	public String showMyOrders(@PathVariable("uid") int userId,Model m) {
		List<UserOrderViewObject> myOrders = this.userDao.getMyOrders(userId);
		m.addAttribute("uid", userId);
		m.addAttribute("orders", myOrders);
		return "userOrder";
	}
	
	@RequestMapping("/getuser/{uid}")
	public String getUser(@PathVariable("uid") int userId,Model m) {
		User user=userDao.getUser(userId);
		m.addAttribute("user",user);
		return "updateUser";
	}
	
	@RequestMapping("/updateuser")
	private RedirectView updateUser(@ModelAttribute User user,@RequestParam("uid") int userId,HttpServletRequest request) {
		userDao.createUser(user);
		System.out.println(user);
		String url="/userprofile/"+userId;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
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
