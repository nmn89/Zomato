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

import zomatoapp.dao.OrderDishDao;
import zomatoapp.dao.OrderDishDaoHibernate;
import zomatoapp.model.OrderDish;
import zomatoapp.viewobjects.OrderDishesViewObject;

@Controller
public class OrderDishController {

	@Autowired
	private OrderDishDao orderDishDao;
	
	@Autowired
	private OrderDishDaoHibernate orderDishDaoHibernate;
	
	@RequestMapping("/orderdishadded")
	public RedirectView createOrderDish(@RequestParam("restaurantId") int restaurantId,@RequestParam("userId") int userId,@ModelAttribute OrderDish orderDish,@RequestParam("orderId") int orderId,HttpServletRequest request) {
		orderDishDaoHibernate.addOrderDish(orderDish);
		String url="/successfull/"+orderId+"/"+restaurantId+"/"+userId;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/getorderdish/{orid}")
	public String getOrderDish(@PathVariable("orid") int orderId,Model m) {
		List<OrderDishesViewObject> orderDish = orderDishDao.getOrderDish(orderId);
		m.addAttribute("orders", orderDish);
		return "orderedDish";
	}
}