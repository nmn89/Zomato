package zomatoapp.controller;

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
	public RedirectView addOrder(@RequestParam("uid") int uid,@RequestParam("rid") int rid,@ModelAttribute UserOrder userOrder,Model m) {
		userOrderDao.addOrder(userOrder);
		m.addAttribute("order", userOrder);
		String url="getorder/"+uid;
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);
		return redirectView;
	}
	
	@RequestMapping("order/{orderId}")
	public String getOrder(@PathVariable("orderId") int uoId,Model m) {
		UserOrder userOrder = userOrderDao.getOrder(uoId);
		m.addAttribute("order", userOrder);
		return "order";
	}
}