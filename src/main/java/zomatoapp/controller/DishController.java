package zomatoapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import zomatoapp.dao.DishDao;
import zomatoapp.model.Dish;

@Controller
public class DishController {

	@Autowired
	private DishDao dishDao;
	
	@RequestMapping("/dishadded/{rid}")
	public String addDish(@PathVariable("rid") int rId,@ModelAttribute Dish dish,Model m) {
		this.dishDao.createDish(dish);
		m.addAttribute("rid", rId);
		return "dishAdded";
	}
	
	@RequestMapping("/removedish/{dishid}/{rid}")
	public RedirectView removeDish(@PathVariable("dishid") int dId,@PathVariable("rid") int rid,HttpServletRequest request) {
		this.dishDao.deleteDish(dId);
		String url = "/showdish/"+rid;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/dish/{dishid}")
	public String getDish(@PathVariable("dishid") int dId,Model m) {
		Dish dish = this.dishDao.getDish(dId);
		m.addAttribute("dish", dish);
		return "myDish";
	}
}
