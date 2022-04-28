package com.restaurant;

import com.restaurant.model.Category;
import com.restaurant.service.IItemsService;
import com.restaurant.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestaurantappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestaurantappJdbcApplication.class, args);
	}
	IRestaurantService restaurantService;
	IItemsService itemsService;
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

//		restaurantService.findAllRestaurants().forEach(System.out::println);
//		restaurantService.findByItemName("Shawarma").forEach(System.out::println);
//		restaurantService.findByLocation("Hyderabad").forEach(System.out::println);
//		restaurantService.findByNameStarting("Me").forEach(System.out::println);
//		restaurantService.findByType("VEG").forEach(System.out::println);

//		itemsService.findByCategory(9,"DRINKS").forEach(System.out::println);
//		itemsService.findByRestaurantName(707).forEach(System.out::println);
	}
}
