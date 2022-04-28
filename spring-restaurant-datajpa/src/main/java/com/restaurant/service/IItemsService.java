package com.restaurant.service;

import com.restaurant.exceptions.ItemNotFoundException;
import com.restaurant.model.Item;

import java.util.List;

public interface IItemsService {
    List<Item> findByRestaurantName(int restaurantId) throws ItemNotFoundException;

    List<Item> findByCategory(int restaurantId, String category) throws ItemNotFoundException;

    void addItems(Item item);

    void updateItem(Item item);

    void deleteItem(int itemId);
}
