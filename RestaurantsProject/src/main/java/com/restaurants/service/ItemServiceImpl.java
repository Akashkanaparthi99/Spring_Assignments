package com.restaurants.service;

import java.util.List;
import java.util.stream.Collectors;

import com.restaurants.exceptions.InvalidItemIdException;
import com.restaurants.exceptions.ItemNotFoundException;
import com.restaurants.model.Item;
import com.restaurants.repository.IItemsDao;
import com.restaurants.repository.ItemDaoImpl;

public class ItemServiceImpl implements IItemService {

	IItemsDao itemsDao = new ItemDaoImpl();
	@Override
	public List<Item> findByRestaurantName(int restaurantId) throws ItemNotFoundException {
		return itemsDao.getByRestaurantName(restaurantId).stream().sorted((o1, o2) -> o1.getItemName().compareTo(o2.getItemName())).collect(Collectors.toList());
	}

	@Override
	public List<Item> findByCategory(int restaurantId, String category) throws ItemNotFoundException {
		return itemsDao.getByCategory(restaurantId, category).stream().sorted((o1, o2) -> o1.getItemName().compareTo(o2.getItemName())).collect(Collectors.toList());
	}

	@Override
	public void addItems(Item item) {
		itemsDao.addItems(item);
	}

	@Override
	public void updateItem(int itemId, double price) throws InvalidItemIdException {
		itemsDao.updateItem(itemId, price);
	}

	@Override
	public void deleteItem(int itemId) throws InvalidItemIdException {
		itemsDao.deleteItem(itemId);
	}

}
