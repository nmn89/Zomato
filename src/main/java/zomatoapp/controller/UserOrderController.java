package zomatoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.UserOrderDao;
import zomatoapp.model.UserOrder;

@Controller
public class UserOrderController {

	private UserOrderDao userOrderDao;
	
	@RequestMapping("/addorder")
	public String addOrder(@ModelAttribute UserOrder userOrder) {
		this.userOrderDao.addOrder(userOrder);
		return "homePage";
	}
	
	@RequestMapping("order/{orderId}")
	public String getOrder(@PathVariable("orderId") int uoId,Model m) {
		UserOrder userOrder = userOrderDao.getOrder(uoId);
		m.addAttribute("order", userOrder);
		return "order";
	}
}