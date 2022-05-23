package zomatoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.LocationDao;
import zomatoapp.model.Location;

@Controller
public class LocationController {

	@Autowired
	private LocationDao locationDao;
	
	@RequestMapping("/location")
	public String getAllLocation(Model m){
		List<Location> location = locationDao.getAllLocation();
		m.addAttribute("locations", location);
		return "home";
	}
}
