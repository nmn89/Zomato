package zomatoapp.main;


import java.util.List;

import org.springframework.context.ApplicationContext;
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
		
		UserDao userDao = context.getBean(UserDao.class);
		User user = new User(1,"Aakash Singh","singh89aakash@gmail.com",987809676,"aakash89");
		userDao.createUser(user);
		
		User user2 = userDao.getUser(1);
		System.out.println(user2);
		
		List<Restaurant> rest = userDao.getRestaurants("Delhi");
		System.out.println(rest);
		
		UserOrder userOrder = new UserOrder(4,"15/2/2004",1,3);
		System.out.println(userOrder);
		userDao.addOrder(userOrder);
		
		List<UserOrder> uo = userDao.getMyOrder(1);
		System.out.println(uo);
		
		Restaurant rest3 = userDao.searchRestaurant("Lazeez Restaurant");
		System.out.println(rest3);
		
	
		OwnerDao ownerDao = context.getBean(OwnerDao.class);
		Owner owner = new Owner(1,"Sharad Maurya","msharad@gmail.com",8798,"sharad");
		ownerDao.createOwner(owner);
		
		Owner owner2= ownerDao.getOwner(1);
		System.out.println(owner2);
		
		Restaurant restaurant = new Restaurant(2,"Classic Restaurant","Delhi",1);
		ownerDao.addRestaurant(restaurant);
		
		List<Restaurant> rest2= ownerDao.getMyResaurant(1);
		System.out.println(rest2);
		
		
		RestaurantDao restaurantDao = context.getBean(RestaurantDao.class);
		Dish dish = new Dish(6,"Tandoori Roti",20,1,2);
		restaurantDao.addDish(dish);
		
		List<Dish> dish2 = restaurantDao.getMyDishes(2);
		System.out.println(dish2);
		
	}
}