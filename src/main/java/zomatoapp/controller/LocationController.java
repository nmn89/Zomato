package zomatoapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import zomatoapp.dao.LocationDao;
import zomatoapp.model.Location;

@Controller
public class LocationController {

	@Autowired
	private LocationDao locationDao;
	
	@RequestMapping("/locationadded/{ownerid}")
	public RedirectView addLocation(@ModelAttribute Location location,@PathVariable("ownerid") int ownerId,HttpServletRequest request) {
		this.locationDao.addLocation(location);
		String url ="/location/"+ownerId;
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/location/{oid}")
	public String getAllLocations(@PathVariable("oid") int ownerId,Model m){
		List<Location> locations = locationDao.getAllLocations();
		m.addAttribute("oid", ownerId);
		m.addAttribute("locations", locations);
		return "addMyRestaurant";
	}
	
	
}
