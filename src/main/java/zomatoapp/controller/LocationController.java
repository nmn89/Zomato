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
	
	@RequestMapping("/locationadded")
	public String addLocation(@ModelAttribute Location location,Model m) {
		this.locationDao.addLocation(location);
		m.addAttribute("location", location);
		return "location";
	}
	
	@RequestMapping("/location/{oid}")
	public String getAllLocations(@PathVariable("oid") int ownerId,Model m){
		List<Location> locations = locationDao.getAllLocations();
		m.addAttribute("id", ownerId);
		m.addAttribute("locations", locations);
		return "location";
	}
	
	
}
