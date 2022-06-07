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

import zomatoapp.dao.LocationDao;
import zomatoapp.dao.OrderDishDao;
import zomatoapp.dao.UserDao;
import zomatoapp.dao.UserDaoHibernate;
import zomatoapp.model.Location;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;
import zomatoapp.viewobjects.OrderDishesViewObject;
import zomatoapp.viewobjects.UserOrderViewObject;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDaoHibernate userDaoHibernate;
	
	@Autowired
	private LocationDao locationDao;
	
	@Autowired
	private OrderDishDao orderDishDao;
	
	@RequestMapping("/register")
	public String userRegister(@ModelAttribute User user,Model m) {
		userDaoHibernate.createUser(user);
		return "userLogin";
	}
	
	@RequestMapping("/userprofile/{uid}")
	public String userProfile(@PathVariable("uid") int userId,Model m) {
		User user = this.userDaoHibernate.getUser(userId);
		Location location= this.locationDao.getLocation(user.getDefaultLocationId());
		m.addAttribute("location", location.getLocation());
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
	
	@RequestMapping("/searchrestaurant/{userid}")
	public String searchRestaurant(@RequestParam("restaurantName") String rName,@PathVariable("userid") int userId,Model m) {
		Restaurant restaurant = this.userDao.searchRestaurant(rName);
		m.addAttribute("restaurant", restaurant);
		m.addAttribute("uid", userId);
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
		User user=userDaoHibernate.getUser(userId);
		List<Location> locations = locationDao.getAllLocations();
		m.addAttribute("locations", locations);
		m.addAttribute("user",user);
		return "updateUser";
	}
	
	@RequestMapping("/updateuser")
	private RedirectView updateUser(@ModelAttribute User user,@RequestParam("id") int userId,HttpServletRequest request) {
		userDaoHibernate.createUser(user);
		System.out.println(user);
		String url="/userprofile/"+userId;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/userhome")
	public RedirectView userHome(@RequestParam("email") String email,@RequestParam("password") String password,Model m,HttpServletRequest request) {
		int id = userDao.authenticateUser(email, password);
		if(id!=0) {
			int locationId = userDao.getUserLocation(id);
			String url="/userhome/"+id+"/"+locationId;
			RedirectView redirectView= new RedirectView();
			redirectView.setUrl(request.getContextPath()+url);
			return redirectView;
		}
		else {
			String url="/login";
			RedirectView redirectView= new RedirectView();
			redirectView.setUrl(request.getContextPath()+url);
			return redirectView;
		}
	}
}
