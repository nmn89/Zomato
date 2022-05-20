package zomatoapp.main;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zomatoapp.dao.UserOrderDao;
import zomatoapp.dao.OwnerDao;
import zomatoapp.dao.RestaurantDao;
import zomatoapp.dao.UserDao;
import zomatoapp.model.UserOrder;
import zomatoapp.model.Dish;
import zomatoapp.model.Owner;
import zomatoapp.model.Restaurant;
import zomatoapp.model.User;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("Program Started+++++++++++++++++++++++++++");
		ApplicationContext context = new ClassPathXmlApplicationContext("zomatoapp/main/configg.xml");
		
		RestaurantDao restaurantDao = context.getBean(RestaurantDao.class);
		List<Dish> dish = restaurantDao.getMyDishes(2);
		System.out.println(dish);
	}
}