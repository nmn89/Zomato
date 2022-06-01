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

import zomatoapp.dao.OwnerDao;
import zomatoapp.model.Location;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;

@Controller
public class OwnerController {

	@Autowired
	private OwnerDao ownerDao;
	
	@RequestMapping("/owner")
	public String addOwner(@ModelAttribute Owner owner,Model m) {
		ownerDao.createOwner(owner);
		m.addAttribute("msg", "Owner added successfully");
		return "ownerLogin";
	}
	
	@RequestMapping("/remove/{oid}")
	public String removeOwner(@PathVariable("oid") int ownerId) {
		this.ownerDao.deleteOwner(ownerId);
		return "loginOwner";
	}
	
	@RequestMapping("/ownerprofile/{oid}")
	public String ownerProfile(@PathVariable("oid") int ownerId,Model m){
		Owner owner = this.ownerDao.getOwner(ownerId);
		m.addAttribute("owner", owner);
		return "ownerProfile";
	}
	
	@RequestMapping("/restaurantadded/{oid}")
	public String addRestaurant(@PathVariable("oid") int ownerId,@ModelAttribute Restaurant restaurant,Model m) {
		this.ownerDao.addRestaurant(restaurant);
		m.addAttribute("oid", ownerId);
		return "restaurantAdded";
	}
	
	@RequestMapping("/removerestaurant/{rid}/{oid}")
	public RedirectView removeRestaurant(@PathVariable("rid") int restaurantId,@PathVariable("oid") int ownerId,HttpServletRequest request) {
		this.ownerDao.removeRestaurant(restaurantId);
		String url = "/ownerrestaurant/"+ownerId;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/ownerrestaurant/{oid}")
	public String myRestaurants(@PathVariable("oid") int ownerId,Model m) { 
		List<Restaurant> restaurants = this.ownerDao.getMyResaurants(ownerId);
		m.addAttribute("oid",ownerId);
		m.addAttribute("restaurants", restaurants);
		return "ownerRestaurant";
	}
	
	@RequestMapping("/getowner/{oid}")
	public String getOwner(@PathVariable("oid") int ownerId,Model m) {
		Owner owner=ownerDao.getOwner(ownerId);
		m.addAttribute("owner",owner);
		return "updateOwner";
	}
	
	@RequestMapping("/updateowner")
	private RedirectView updateOwner(@ModelAttribute Owner owner,@RequestParam("oid") int ownerId,HttpServletRequest request) {
		ownerDao.createOwner(owner);
		System.out.println(owner);
		String url="/ownerprofile/"+ownerId;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/ownerhome")
	public String ownerHome(@RequestParam("email") String email,@RequestParam("password") String password,Model m) {
		int id = ownerDao.authenticateOwner(email, password);
		if(id!=0) {
			m.addAttribute("oid", id);
			return "ownerHome";
		}
		else {
			m.addAttribute("msg", "Entered email or password is wrong...");
			return "ownerLogin";
		}
	}
}
