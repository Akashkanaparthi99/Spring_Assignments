package com.restaurant.service;

import com.restaurant.exceptions.ItemNotFoundException;
import com.restaurant.model.Item;
import com.restaurant.repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements IItemsService{
    @Autowired
    IItemRepository itemRepository;

    @Override
    public List<Item> findByRestaurantName(int restaurantId) throws ItemNotFoundException {
        List<Item> items = itemRepository.getByRestaurantName(restaurantId);
        if (items.isEmpty()){
            throw new ItemNotFoundException("Item Not Found");
        }
        return items;
    }

    @Override
    public List<Item> findByCategory(int restaurantId, String category) throws ItemNotFoundException {
        List<Item> items = itemRepository.getByCategory(restaurantId,category);
        if (items.isEmpty()){
            throw new ItemNotFoundException("Item Not Found");
        }
        return items;
    }

    @Override
    public void addItems(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(int itemId) {
        itemRepository.deleteById(itemId);
    }
}
