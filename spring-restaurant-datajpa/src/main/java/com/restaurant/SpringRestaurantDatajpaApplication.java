package com.restaurant;

import com.restaurant.model.Category;
import com.restaurant.model.Item;
import com.restaurant.model.ItemType;
import com.restaurant.model.Restaurant;
import com.restaurant.service.IItemsService;
import com.restaurant.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringRestaurantDatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestaurantDatajpaApplication.class, args);
	}

	private IRestaurantService restaurantService;
	private IItemsService itemsService;
	@Autowired
	public void setRestaurantService(IRestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	@Autowired
	public void setItemsService(IItemsService itemsService) {
		this.itemsService = itemsService;
	}

	@Override
	public void run(String... args) throws Exception {
//		Item item1 = new Item("Mutton Bone Soup", ItemType.NON_VEG.type,360,Category.SOUPS.name());
//		Item item2 = new Item("Panner 65", ItemType.VEG.type,210 ,Category.STARTERS.name());
//		Item item3 = new Item("Panner Dosa", ItemType.VEG.type,120 ,Category.STARTERS.name());
//		Item item4 = new Item("Chicken Dum Biryani", ItemType.NON_VEG.type, 550,Category.MAIN_COURSE.name());
//
//		Set<Item> items = new HashSet<>(Arrays.asList(item1,item2,item3,item4));
//		Restaurant restaurant = new Restaurant("Pista House",ItemType.NON_VEG.type,"Hyderabad",4.5,items);
//
//		restaurantService.addRestaurant(restaurant);

//		Item item1 = new Item("Mutton Bone Soup", ItemType.NON_VEG.type,360,Category.SOUPS.name());
//		Item item2 = new Item("Panner 65", ItemType.VEG.type,210 ,Category.STARTERS.name());
//		Item item3 = new Item("Panner Dosa", ItemType.VEG.type,120 ,Category.STARTERS.name());
//		Item item4 = new Item("Chicken Dum Biryani", ItemType.NON_VEG.type, 550,Category.MAIN_COURSE.name());
//
//		Set<Item> items = new HashSet<>(Arrays.asList(item1,item2,item3,item4));
//		Restaurant restaurant = new Restaurant("Mehfil",ItemType.NON_VEG.type,"Hyderabad",4.0,items);
//
//		restaurantService.addRestaurant(restaurant);
//		Item item1 = new Item("Corn Soup", ItemType.VEG.type,360,Category.SOUPS.name());
//		Item item2 = new Item("Panner 65", ItemType.VEG.type,210 ,Category.STARTERS.name());
//		Item item3 = new Item("Panner Dosa", ItemType.VEG.type,120 ,Category.STARTERS.name());
//		Item item4 = new Item("Veg Fried Rice", ItemType.VEG.type, 250,Category.MAIN_COURSE.name());
//
//		Set<Item> items = new HashSet<>(Arrays.asList(item1,item2,item3,item4));
//		Restaurant restaurant = new Restaurant("Chutneys",ItemType.VEG.type,"Hyderabad",4.2,items);
//
//		restaurantService.addRestaurant(restaurant);
//		restaurantService.findAllRestaurants().forEach(System.out::println);
//		restaurantService.findByNameStarting("M").forEach(System.out::println);
//		restaurantService.findByType(ItemType.NON_VEG.type).forEach(System.out::println);
//		restaurantService.findByItemName("Panner Dosa").forEach(System.out::println);
	}

}
