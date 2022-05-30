package zomatoapp.controller;

import java.util.ArrayList;
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

import zomatoapp.dao.UserOrderDao;
import zomatoapp.model.UserOrder;

@Controller
public class UserOrderController {

	@Autowired
	private UserOrderDao userOrderDao;
	
	@RequestMapping("/addorder")
	public RedirectView addOrder(@RequestParam("uid") int uid,@RequestParam("rid") int rid,@ModelAttribute UserOrder userOrder,Model m,HttpServletRequest request) {
		userOrderDao.addOrder(userOrder);
		String url="/showrestaurantdish/"+rid+"/"+uid+"/"+userOrder.getOrId();
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/order/{orderid}")
	public String getOrder(@PathVariable("orderid") int uoId,Model m) {
		UserOrder userOrder = userOrderDao.getOrder(uoId);
		m.addAttribute("order", userOrder);
		return "order";
	}
	
	@RequestMapping("/deleteorder/{orderid}/{userid}")
	public RedirectView deleteOrder(@PathVariable("orderid") int oId,@PathVariable("userid") int uid,HttpServletRequest request) {
		this.userOrderDao.deleteOrder(oId);
		String url="/getorder/"+uid;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
}