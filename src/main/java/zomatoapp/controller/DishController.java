package zomatoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.DishDao;
import zomatoapp.model.Dish;

@Controller
public class DishController {

	@Autowired
	private DishDao dishDao;
	
	@RequestMapping("/dishadded")
	public String addDish(@ModelAttribute Dish dish) {
		this.dishDao.createDish(dish);
		return "myDish";
	}
	
	@RequestMapping("/remove/{dishId}")
	public String removeDish(@PathVariable("dishId") int dId) {
		this.dishDao.deleteDish(dId);
		return "myDish";
	}
	
	@RequestMapping("dish/{dishId}")
	public String getDish(@PathVariable("dishId") int dId,Model m) {
		Dish dish = this.dishDao.getDish(dId);
		m.addAttribute("dish", dish);
		return "myDish";
	}
}
