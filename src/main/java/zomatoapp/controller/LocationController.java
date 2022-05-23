package zomatoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.LocationDao;
import zomatoapp.model.Location;

@Controller
public class LocationController {

	@Autowired
	private LocationDao locationDao;
	
	@RequestMapping("/addlocation")
	public String addLocation(@ModelAttribute Location location) {
		this.locationDao.addLocation(location);
		return "myRestaurant";
	}
	
	@RequestMapping("/location")
	public String getAllLocations(Model m){
		List<Location> locations = locationDao.getAllLocations();
		m.addAttribute("locations", locations);
		return "home";
	}
	
	
}
