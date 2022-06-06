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
import zomatoapp.dao.OwnerDao;
import zomatoapp.dao.OwnerDaoHibernate;
import zomatoapp.model.Location;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;

@Controller
public class OwnerController {

	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private OwnerDaoHibernate ownerDaoHibernate;
	
	@Autowired
	private LocationDao locationDao;
	
	@RequestMapping("/owner")
	public String addOwner(@ModelAttribute Owner owner,Model m) {
		ownerDaoHibernate.createOwner(owner);
		m.addAttribute("msg", "Owner added successfully");
		return "ownerLogin";
	}
	
	@RequestMapping("/deleteowner/{oid}")
	public String removeOwner(@PathVariable("oid") int ownerId) {
		this.ownerDao.deleteOwner(ownerId);
		return "ownerLogin";
	}
	
	@RequestMapping("/ownerprofile/{oid}")
	public String ownerProfile(@PathVariable("oid") int ownerId,Model m){
		Owner owner = this.ownerDaoHibernate.getOwner(ownerId);
		m.addAttribute("owner", owner);
		return "ownerProfile";
	}
	
	@RequestMapping("/restaurantadded/{oid}")
	public RedirectView addRestaurant(@PathVariable("oid") int ownerId,@ModelAttribute Restaurant restaurant,Model m,HttpServletRequest request) {
		this.ownerDaoHibernate.addRestaurant(restaurant);
		m.addAttribute("oid", ownerId);
		String url = "/ownerrestaurant/"+ownerId;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
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
		List<Location> locations = locationDao.getAllLocations();
		m.addAttribute("locations", locations);
		m.addAttribute("oid",ownerId);
		m.addAttribute("restaurants", restaurants);
		return "ownerHome";
	}
	
	@RequestMapping("/getowner/{oid}")
	public String getOwner(@PathVariable("oid") int ownerId,Model m) {
		Owner owner=ownerDaoHibernate.getOwner(ownerId);
		m.addAttribute("owner",owner);
		return "updateOwner";
	}
	
	@RequestMapping("/updateowner")
	private RedirectView updateOwner(@ModelAttribute Owner owner,@RequestParam("id") int ownerId,HttpServletRequest request) {
		ownerDaoHibernate.createOwner(owner);
		System.out.println(owner);
		String url="/ownerprofile/"+ownerId;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/ownerhome")
	public RedirectView ownerHome(@RequestParam("email") String email,@RequestParam("password") String password,Model m,HttpServletRequest request) {
		int id = ownerDao.authenticateOwner(email, password);
		if(id!=0) {
			String url="/ownerrestaurant/"+id;
			RedirectView redirectView= new RedirectView();
			redirectView.setUrl(request.getContextPath()+url);
			return redirectView;
		}
		else {
			String url="/ownerrelogin";
			RedirectView redirectView=new RedirectView();
			redirectView.setUrl(request.getContextPath()+url);
			return redirectView;
		}
	}
}
