package com.restaurants.repository;

import java.util.List;

import com.restaurants.model.Item;

public interface IItemsDao {

	// list of items
	List<Item> getByRestaurantName(int restaurantId) ;

	List<Item> getByCategory(int restaurantId, String category) ;

	// adding items
	void addItems(Item item);

	void updateItem(int itemId, double price) ;

	void deleteItem(int itemId) ;
}
