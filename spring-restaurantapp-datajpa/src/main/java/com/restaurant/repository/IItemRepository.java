package com.restaurant.repository;

import com.restaurant.model.Item;

import java.util.List;

public interface IItemRepository {
    // list of items
    List<Item> getByRestaurantName(int restaurantId) ;

    List<Item> getByCategory(int restaurantId, String category) ;

    // adding items
    void addItems(Item item);

    void updateItem(int itemId, double price) ;

    void deleteItem(int itemId) ;
}
