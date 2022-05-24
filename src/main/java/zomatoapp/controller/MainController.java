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

import zomatoapp.login.LoginAuthentication;
import zomatoapp.model.Dish;
import zomatoapp.model.Owner;
import zomatoapp.model.User;

@Controller
public class MainController {
	
	@Autowired
	private LoginAuthentication loginAuthentication;
	
	@RequestMapping("/")
	public String loginUser() {
		return "userLogin";
	}
	
	@RequestMapping("/userhome")
	public String userHome(@RequestParam("mobileNo") long mobileNo,@RequestParam("password") String password,Model m) {
		int id = loginAuthentication.authenticateUser(mobileNo, password);
		if(id!=0) {
			m.addAttribute("uid", id);
			return "userHome";
		}
		else {
			return "userLogin";
		}
	}
	
	@RequestMapping("/ownerhome")
	public String ownerHome(@RequestParam("email") String email,@RequestParam("password") String password,Model m) {
		int id = loginAuthentication.authenticateOwner(email, password);
		if(id!=0) {
			m.addAttribute("oid", id);
			return "ownerHome";
		}
		else {
			return "ownerLogin";
		}
	}
	
	@RequestMapping("/registerUser")
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
	
	@RequestMapping("/addrestaurant/{locationId}/{ownerId}")
	public String createRestaurant(@PathVariable("locationId") int lId,@PathVariable("ownerId") int oId,Model m) {
		System.out.println(lId);
		System.out.println(oId);
		m.addAttribute("lid", lId);
		m.addAttribute("oid", oId);
		return "addRestaurant";
	}
	
	@RequestMapping("/adddish/{rId}")
	public String addDish(@PathVariable("rId") int rId,Model m) {
		m.addAttribute("rid", rId);
		return "addDish";
	}
}
