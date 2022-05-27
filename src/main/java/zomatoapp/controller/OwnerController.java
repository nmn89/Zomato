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
	
	@RequestMapping("/remove/{ownerid}")
	public String removeOwner(@PathVariable("ownerid") int oId) {
		this.ownerDao.deleteOwner(oId);
		return "loginOwner";
	}
	
	@RequestMapping("/ownerprofile/{ownerid}")
	public String ownerProfile(@PathVariable("ownerid") int oId,Model m){
		Owner owner = this.ownerDao.getOwner(oId);
		m.addAttribute("owner", owner);
		return "ownerProfile";
	}
	
	@RequestMapping("/restaurantadded/{ownerid}")
	public String addRestaurant(@PathVariable("ownerid") int oid,@ModelAttribute Restaurant restaurant,Model m) {
		this.ownerDao.addRestaurant(restaurant);
		m.addAttribute("oid", oid);
		return "restaurantAdded";
	}
	
	@RequestMapping("/removerestaurant/{restaurantid}/{ownerid}")
	public RedirectView removeRestaurant(@PathVariable("restaurantid") int rId,@PathVariable("ownerid") int oId,HttpServletRequest request) {
		this.ownerDao.removeRestaurant(rId);
		String url = "/ownerrestaurant/"+oId;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/ownerrestaurant/{ownerid}")
	public String myRestaurants(@PathVariable("ownerid") int oId,Model m) { 
		List<Restaurant> restaurants = this.ownerDao.getMyResaurants(oId);
		m.addAttribute("oid",oId);
		m.addAttribute("restaurants", restaurants);
		return "ownerRestaurant";
	}
	
	@RequestMapping("/getowner/{ownerid}")
	public String getOwner(@PathVariable("ownerid") int oid,Model m) {
		Owner owner=ownerDao.getOwner(oid);
		m.addAttribute("owner",owner);
		return "updateOwner";
	}
	
	@RequestMapping("/updateowner")
	private RedirectView updateOwner(@ModelAttribute Owner owner,@RequestParam("oid") int oid,HttpServletRequest request) {
		ownerDao.createOwner(owner);
		System.out.println(owner);
		String url="/ownerprofile/"+oid;
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
