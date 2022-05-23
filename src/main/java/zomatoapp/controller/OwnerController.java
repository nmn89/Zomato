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
	
	@RequestMapping("/Owner")
	public String addOwner(@ModelAttribute Owner owner,Model m) {
		ownerDao.createOwner(owner);
		m.addAttribute("msg", "Owner added successfully");
		return "loginOwner";
	}
	
	@RequestMapping("/remove/{ownerId}")
	public String removeOwner(@PathVariable("ownerId") int oId) {
		this.ownerDao.deleteOwner(oId);
		return "loginOwner";
	}
	
	@RequestMapping("/ownerProfile/{ownerId}")
	public String ownerProfile(@PathVariable("ownerId") int oId,Model m){
		Owner owner = this.ownerDao.getOwner(oId);
		m.addAttribute("owner", owner);
		return "ownerProfile";
	}
	
	@RequestMapping("/restaurantRegister")
	public String addRestaurant(@ModelAttribute Restaurant restaurant) {
		this.ownerDao.addRestaurant(restaurant);
		return "myRestaurant";
	}
	
	@RequestMapping("/remove/{restaurantId}")
	public String removeRestaurant(@PathVariable("restaurantId") int rId) {
		this.ownerDao.removeRestaurant(rId);
		return "myRestaurant";
	}
	
	@RequestMapping("/Restaurant/{ownerId}")
	public String myRestaurant(@PathVariable("ownerId") int oId,Model m) { 
		List<Restaurant> restaurant = this.ownerDao.getMyResaurant(oId);
		m.addAttribute("restaurant", restaurant);
		return "myRestaurant";
	}
	
	@RequestMapping("/Location")
	public String addLocation(@ModelAttribute Location location) {
		this.ownerDao.addLocation(location);
		return "myRestaurant";
	}
}
