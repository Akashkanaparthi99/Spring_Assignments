package com.restaurants.service;

import java.util.List;

import com.restaurants.exceptions.InvalidItemIdException;
import com.restaurants.exceptions.ItemNotFoundException;
import com.restaurants.model.Item;

public interface IItemService {
	List<Item> findByRestaurantName(int restaurantId) throws ItemNotFoundException;

	List<Item> findByCategory(int restaurantId, String category) throws ItemNotFoundException;

	void addItems(Item item);

	void updateItem(int itemId, double price) throws InvalidItemIdException;

	void deleteItem(int itemId) throws InvalidItemIdException;
}
