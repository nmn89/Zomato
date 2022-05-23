package zomatoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import zomatoapp.dao.UserOrderDao;
import zomatoapp.model.UserOrder;

@Controller
public class UserOrderController {

	private UserOrderDao userOrderDao;
	
	@RequestMapping("delete/{orderId}")
	public String deleteOrder(@PathVariable("orderId") int oId) {
		this.userOrderDao.deleteOrder(oId);
		return "myOrder";
	}
	
	@RequestMapping("order/{orderId}")
	public String getOrder(@PathVariable("orderId") int uoId,Model m) {
		UserOrder userOrder = userOrderDao.getOrder(uoId);
		m.addAttribute("order", userOrder);
		return "order";
	}
}
