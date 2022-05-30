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
import zomatoapp.model.OrderDish;

@Controller
public class OrderDishController {

	@Autowired
	private OrderDishDao orderDishDao;
	
	@RequestMapping("/orderdishadded")
	public RedirectView createOrderDish(@ModelAttribute OrderDish orderDish,@RequestParam("uId") int uId,@RequestParam("rId") int rId,@RequestParam("orId") int orId,HttpServletRequest request) {
		orderDishDao.addOrderDish(orderDish);
		String url="/successfull/"+uId+"/"+rId+"/"+orId;
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+url);
		return redirectView;
	}
	
	@RequestMapping("/getorderdish/{orid}")
	public String getOrderDish(@PathVariable("orid") int orId,Model m) {
		List<OrderDish> orderDish = orderDishDao.getOrderDish(orId);
		m.addAttribute("orders", orderDish);
		return "userOrderDish";
	}
}
