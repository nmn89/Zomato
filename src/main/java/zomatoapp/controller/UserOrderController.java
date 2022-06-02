package zomatoapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import zomatoapp.dao.UserOrderDao;
import zomatoapp.dao.UserOrderDaoHibernate;
import zomatoapp.model.UserOrder;

@Controller
public class UserOrderController {

	@Autowired
	private UserOrderDao userOrderDao;
	
	@Autowired
	private UserOrderDaoHibernate userOrderDaoHibernate;
	
	@RequestMapping("/addorder/{uid}/{rid}")
	public RedirectView addOrder(@PathVariable("uid") int userId,@PathVariable("rid") int restaurantId,@ModelAttribute UserOrder userOrder,Model m,HttpServletRequest request) {
		userOrderDaoHibernate.addOrder(userOrder);
		String url="/showrestaurantdish/"+restaurantId+"/"+userId+"/"+userOrder.getId();
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/order/{orid}")
	public String getOrder(@PathVariable("orid") int orderId,Model m) {
		UserOrder userOrder = userOrderDaoHibernate.getOrder(orderId);
		m.addAttribute("order", userOrder);
		return "order";
	}
	
	@RequestMapping("/deleteorder/{orid}/{uid}")
	public RedirectView deleteOrder(@PathVariable("orid") int orderId,@PathVariable("uid") int userId,HttpServletRequest request) {
		this.userOrderDao.deleteOrder(orderId);
		String url="/getorder/"+userId;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
}