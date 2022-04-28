package com.restaurant.service;

import com.restaurant.exceptions.InvalidItemIdException;
import com.restaurant.exceptions.ItemNotFoundException;
import com.restaurant.model.Item;
import com.restaurant.repository.IItemRepository;
import com.restaurant.repository.ItemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements IItemsService{
    @Autowired
    IItemRepository repository;

    @Override
    public List<Item> findByRestaurantName(int restaurantId) throws ItemNotFoundException {
        List<Item> items = repository.getByRestaurantName(restaurantId);
        if (items.isEmpty()){
            throw new ItemNotFoundException("Item Not Found");
        }
        return items;
    }

    @Override
    public List<Item> findByCategory(int restaurantId, String category) throws ItemNotFoundException {
        List<Item> items = repository.getByCategory(restaurantId,category);
        if (items.isEmpty()){
            throw new ItemNotFoundException("Item Not Found");
        }
        return items;
    }

    @Override
    public void addItems(Item item) {
        repository.addItems(item);
    }

    @Override
    public void updateItem(int itemId, double price) {
        repository.updateItem(itemId, price);
    }

    @Override
    public void deleteItem(int itemId) {
        repository.deleteItem(itemId);
    }
}
