package com.restaurants.main;


import java.util.List;
import java.util.Scanner;

import com.restaurants.exceptions.InvalidItemIdException;
import com.restaurants.exceptions.ItemNotFoundException;
import com.restaurants.exceptions.NoRestaurantFoundException;
import com.restaurants.model.Item;
import com.restaurants.model.ItemType;
import com.restaurants.model.Restaurant;
import com.restaurants.service.IItemService;
import com.restaurants.service.IRestaurantService;
import com.restaurants.service.ItemServiceImpl;
import com.restaurants.service.RestaurantServiceImpl;

public class Client {
	
	public static void main(String[] args) {
		IRestaurantService iRestaurantService = new RestaurantServiceImpl();
		IItemService itemService = new ItemServiceImpl();
		Restaurant restaurant = new Restaurant();
		Item item = new Item();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 'C' if you are a Customer");
		System.out.println("Enter 'A' if you are a Admin");
		String input = scanner.next();
		char ch = input.toUpperCase().charAt(0);
		if (ch == 'C') {
			System.out.println(
					"---------------------------------------------SEARCH FOR RESTAURANTS-----------------------------------------------");
			System.out.println("Enter '1' to get all Restaurants");
			System.out.println("Enter '2' to get all Restaurants by Starting Letter");
			System.out.println("Enter '3' to get all Restaurants by Location");
			System.out.println("Enter '4' to get all Restaurants by Type (VEG/NON-VEG)");
			System.out.println("Enter '5' to get all Restaurants by Item Name");
			System.out.println(
					"---------------------------------------------SEARCH FOR ITEMS-----------------------------------------------");
			System.out.println("Enter '6' to get all ITEMS by Restaurants ID");
			System.out.println("Enter '7' to get all ITEMS by Restaurant Id & Item Category");
			System.out.print("ENTER YOUR INPUT------->");
			int num = scanner.nextInt();
			switch (num) {
			case 1:
				List<Restaurant> restaurants = iRestaurantService.findAllRestaurants();
				for (Restaurant rest : restaurants) {
					System.out.println(rest);
				}
				break;
			case 2:
				System.out.println();
				System.out.println("Enter the Starting letter of the Restaurant Name : ");
				String rtemp = scanner.next();
				try {
					restaurants = iRestaurantService.findByNameStarting(rtemp);
					for (Restaurant rest : restaurants) {
						System.out.println(rest);
					}
				} catch (NoRestaurantFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println();
				System.out.print("Enter Location ->  ");
				String city = scanner.next();
				try {
					restaurants = iRestaurantService.findByLocation(city);
					for (Restaurant rest : restaurants) {
						System.out.println(rest);
					}
				} catch (NoRestaurantFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println();
				System.out.print("Enter Veg (or) Non-Veg ->  ");
				String type = scanner.next();
				try {
					restaurants = iRestaurantService.findByType(type);
					for (Restaurant rest : restaurants) {
						System.out.println(rest);
					}
				} catch (NoRestaurantFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println();
				System.out.print("Enter ITEM Name -> ");
				String itemName = scanner.next();
				try {
					restaurants = iRestaurantService.findByItemName(itemName);
					for (Restaurant rest : restaurants) {
						System.out.println(rest);
					}
				} catch (NoRestaurantFoundException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 6:
				System.out.println();
				System.out.print("Enter RESTAURANT ID -> ");
				int restId = scanner.nextInt();
				try {
					List<Item> items = itemService.findByRestaurantName(restId);
					for (Item item2 : items) {
						System.out.println(item2);
					}
				} catch (ItemNotFoundException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 7:
				System.out.println();
				System.out.print("Enter RESTAURANT ID -> ");
				restId = scanner.nextInt();
				System.out.print("Enter category ->");
				String category = scanner.next();
				try {
					List<Item> items = itemService.findByCategory(restId, category);
					for (Item item2 : items) {
						System.out.println(item2);
					}
				} catch (ItemNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.err.println("INVALID INPUT");
				break;
			}
		} else if (ch == 'A') {
			System.out.println("-----------WELCOME----------");
			System.out.println("ENTER YOUR LOGIN CREDENTIALS");
			System.out.print("Username : ");
			String username = scanner.next();
			String user = "Akash@01";
			if (username.equals(user)) {
				System.out.print("Password : ");
				String pass = scanner.next();
				String password = "987654@A";
				if (pass.equals(password)) {
					System.out.println("You are SUCCESSFULLY LOGGED IN");
					System.out.println();
					System.out.println("===============ADD RESTAURANT================");
					System.out.println("Enter '1' to ADD RESTAURANT");
					System.out.println("Enter '2' to DELETE RESTAURANT");
					System.out.println("===============ADD ITEM================");
					System.out.println("Enter '3' to ADD ITEM");
					System.out.println("Enter '4' to UPDATE ITEM");
					System.out.println("Enter '5' to DELETE ITEM");
					int iteminput = scanner.nextInt();
					switch (iteminput) {
					case 1:
						int loop = 0;
						do {
							System.out.println();
							System.out.println("Enter Restaurant Details");
							System.out.print("Enter Restaurant ID :- ");
							int restId = scanner.nextInt();
							System.out.print("Enter Restaurant Name :- ");
							String restName = scanner.next();
							System.out.print("Enter Restaurant City :- ");
							String restCity = scanner.next();
							System.out.print("Enter Restaurant Type(VEG/NON-VEG) :- ");
							String restType = scanner.next();
							if (restType.equals("VEG")) {
								restType = ItemType.VEG.name();
							}
							System.out.print("Enter Restaurant RATING :- ");
							double restRating = scanner.nextDouble();
							restaurant = new Restaurant(restId, restName, restCity, restType, restRating);
							iRestaurantService.addRestaurant(restaurant);
							System.out.println();
							int n = 0;
							System.out.println("Enter 'Y' to add items in the Restaurant");
							System.out.println("Enter 'N' to exit");
							String it = scanner.next();
							char thing = it.toUpperCase().charAt(0);
							if (thing == 'Y') {
								do {
									System.out.println();
									System.out.println("Enter ITEM Details");
									System.out.print("Enter ITEM ID :- ");
									int itemId = scanner.nextInt();
									System.out.print("Enter ITEM NAME :- ");
									String itemName = scanner.next();
									System.out.print("Enter ITEM Type(VEG/NON-VEG) :- ");
									String itemType = scanner.next();
									System.out.print("Enter ITEM PRICE :- ");
									double itemPrice = scanner.nextDouble();
									System.out.print("Enter ITEM CATEGORY :- ");
									String itemCategory = scanner.next();
									item = new Item(itemId, itemName, itemType, itemPrice, itemCategory, restId);
									itemService.addItems(item);
									System.out.println("Enter 1 to CONTINUE TO ADD ITEMS & 2 to EXIT");
									System.out.print("-->");
									n = scanner.nextInt();
								} while (n == 1);
							} else if (thing == 'N') {
								System.exit(0);
							} else {
								System.err.println("INVALID INPUT");
							}
							System.out.println("Enter 1 to Add restaurant (or) 2 to exit");
							System.out.print("-->");
							loop = scanner.nextInt();
						} while (loop == 1);
						break;
					case 2:
						System.out.println();
						System.out.print("Enter Restaurant ID :- ");
						int restId = scanner.nextInt();
						iRestaurantService.deleteRestaurant(restId);
						break;
					case 3:
						do {
							System.out.println();
							System.out.println("Enter ITEM Details");
							System.out.print("Enter ITEM ID :- ");
							int itemId = scanner.nextInt();
							System.out.print("Enter ITEM NAME :- ");
							String itemName = scanner.next();
							System.out.print("Enter ITEM Type(VEG/NON-VEG) :- ");
							String itemType = scanner.next();
							System.out.print("Enter ITEM PRICE :- ");
							double itemPrice = scanner.nextDouble();
							System.out.print("Enter ITEM CATEGORY :- ");
							String itemCategory = scanner.next();
							System.out.print("Enter ITEM Restaurant ID :- ");
							restId = scanner.nextInt();
							item = new Item(itemId, itemName, itemType, itemPrice, itemCategory, restId);
							itemService.addItems(item);
							System.out.println("Enter 1 to CONTINUE TO ADD ITEMS & 2 to EXIT");
							System.out.print("-->");
							loop = scanner.nextInt();
						} while (loop == 1);
						break;
					case 4:
						System.out.println();
						System.out.print("Enter ITEM ID :-  ");
						int itemId = scanner.nextInt();
						System.out.println("Enter Undated Price :- ");
						double itemPrice = scanner.nextDouble();
						try {
							itemService.updateItem(itemId, itemPrice);
						} catch (InvalidItemIdException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						System.out.println();
						System.out.print("Enter ITEM ID :-  ");
						itemId = scanner.nextInt();
						try {
							itemService.deleteItem(itemId);
						} catch (InvalidItemIdException e) {
							System.out.println(e.getMessage());
						}
						break;

					default:
						System.err.println("INVALID INPUT");
						break;
					}

				} else {
					System.err.println("WRONG PASSWORD");
				}
			} else {
				System.err.println("INVALID USERNAME");
			}
		} else {
			System.err.println("INVALID INPUT");
		}
	}

}
