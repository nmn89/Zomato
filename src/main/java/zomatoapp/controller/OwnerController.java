package zomatoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.OwnerDao;
import zomatoapp.model.Location;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;

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
	
	@RequestMapping("/remove/{ownerId}")
	public String removeOwner(@PathVariable("ownerId") int oId) {
		this.ownerDao.deleteOwner(oId);
		return "loginOwner";
	}
	
	@RequestMapping("/ownerprofile/{ownerId}")
	public String ownerProfile(@PathVariable("ownerId") int oId,Model m){
		Owner owner = this.ownerDao.getOwner(oId);
		m.addAttribute("owner", owner);
		return "ownerProfile";
	}
	
	@RequestMapping("/restaurantadded")
	public String addRestaurant(@ModelAttribute Restaurant restaurant) {
		this.ownerDao.addRestaurant(restaurant);
		return "ownerHome";
	}
	
	@RequestMapping("/remove/{restaurantId}")
	public String removeRestaurant(@PathVariable("restaurantId") int rId) {
		this.ownerDao.removeRestaurant(rId);
		return "myRestaurant";
	}
	
	@RequestMapping("/ownerrestaurant/{ownerId}")
	public String myRestaurants(@PathVariable("ownerId") int oId,Model m) { 
		List<Restaurant> restaurants = this.ownerDao.getMyResaurants(oId);
		m.addAttribute("restaurants", restaurants);
		return "ownerRestaurant";
	}
}
