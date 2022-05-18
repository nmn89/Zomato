package zomatoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zomatoapp.dao.DishDaoImpl;
import zomatoapp.dao.LoginDao;
import zomatoapp.dao.OwnerDaoImpl;
import zomatoapp.dao.UserDaoImpl;
import zomatoapp.model.Dish;
import zomatoapp.model.Login;
import zomatoapp.model.LoginRestaurant;
import zomatoapp.model.Owner;
import zomatoapp.model.User;

@Controller
public class LoginController {
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Autowired
	private OwnerDaoImpl ownerDaoImpl;
	
	@Autowired
	private DishDaoImpl dishDaoImpl;
	
	@Autowired
	private LoginDao loginDao;

	@RequestMapping("/mainhome")
	public ModelAndView showHome(@ModelAttribute Login login,Model m) {
		ModelAndView mav = null;
		User user = loginDao.validateUser(login);
		if(null!= user) {
			List <Owner> owner= ownerDaoImpl.getAllRestaurant();
			m.addAttribute("rest", owner);
			List <Dish> dish= dishDaoImpl.getAllDishes();
			m.addAttribute("menu", dish);
			mav = new ModelAndView("home");
		}
		else {
			mav = new ModelAndView("login");
			mav.addObject("msg","Mobile Number or password is wrong");
		}
		return mav;
	}
	
	@RequestMapping("/dish")
	public ModelAndView showRestaurant(@ModelAttribute LoginRestaurant loginRestaurant,Model m) {
		ModelAndView mav = null;
		Owner owner = loginDao.validateRestaurant(loginRestaurant);
		if(null!= owner) {
			List <Dish> dish= dishDaoImpl.getAllDishes();
			m.addAttribute("dish", dish);
			mav = new ModelAndView("dish");
		}
		else {
			mav = new ModelAndView("owner_login");
			mav.addObject("msg","Email or password is wrong");
		}
		return mav;
	}
}
