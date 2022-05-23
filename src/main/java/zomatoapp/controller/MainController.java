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

import zomatoapp.dao.DishDaoImpl;
import zomatoapp.dao.OwnerDaoImpl;
import zomatoapp.dao.UserDaoImpl;
import zomatoapp.model.Dish;
import zomatoapp.model.Owner;
import zomatoapp.model.User;

@Controller
public class MainController {

	@Autowired
	private UserDaoImpl userDaoImpl;

	@Autowired
	private OwnerDaoImpl ownerDaoImpl;

	@Autowired
	private DishDaoImpl dishDaoImpl;

	@RequestMapping("/home_restaurant")
	public String showData(Model m) {
		List<Dish> dish = dishDaoImpl.getAllDishes();
		m.addAttribute("dish", dish);
		return "/home_restaurant";
	}

	@RequestMapping("/")
	public String showHome(Model m) {
		List<Owner> owner = ownerDaoImpl.getAllRestaurant();
		m.addAttribute("rest", owner);
		List<Dish> dish = dishDaoImpl.getAllDishes();
		m.addAttribute("menu", dish);
		return "home";
	}

	@RequestMapping("/owner")
	public String showOwner() {
		return "owner";
	}

	@RequestMapping("/login")
	public String showlogin() {
		return "login";
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

	@RequestMapping("/dishes")
	public String addDish() {
		return "dish";
	}

	@RequestMapping("/add/{dId}")
	public String updateForm(@PathVariable("dId") int did, Model model) {
		Dish dish = this.dishDaoImpl.getRestaurant(did);
		model.addAttribute("food", dish);
		return "order";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public RedirectView handleUser(@ModelAttribute User user, HttpServletRequest request) {
		this.userDaoImpl.createUser(user);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/login");
		return redirectView;
	}

	@RequestMapping(value = "/owner_login", method = RequestMethod.POST)
	public RedirectView handleRestaurant(@ModelAttribute Owner owner, HttpServletRequest request) {
		this.ownerDaoImpl.createRestaurant(owner);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/owner_login");
		return redirectView;
	}

	@RequestMapping(value = "/home_restaurant", method = RequestMethod.POST)
	public RedirectView handleDish(@ModelAttribute Dish dish, HttpServletRequest request) {
		this.dishDaoImpl.createDish(dish);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/home_restaurant");
		return redirectView;
	}
}
