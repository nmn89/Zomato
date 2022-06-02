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
import zomatoapp.dao.DishDaoHibernate;
import zomatoapp.model.Dish;

@Controller
public class DishController {

	@Autowired
	private DishDao dishDao;
	
	@Autowired
	private DishDaoHibernate dishDaoHibernate;
	
	@RequestMapping("/dishadded/{rid}")
	public String addDish(@PathVariable("rid") int rid,@ModelAttribute Dish dish,Model m) {
		this.dishDaoHibernate.createDish(dish);
		m.addAttribute("rid", rid);
		return "dishAdded";
	}
	
	@RequestMapping("/removedish/{did}/{rid}")
	public RedirectView removeDish(@PathVariable("did") int did,@PathVariable("rid") int rid,HttpServletRequest request) {
		this.dishDao.deleteDish(did);
		String url = "/showdish/"+rid;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/dish/{did}")
	public String getDish(@PathVariable("did") int did,Model m) {
		Dish dish = this.dishDaoHibernate.getDish(did);
		m.addAttribute("dish", dish);
		return "myDish";
	}
}
