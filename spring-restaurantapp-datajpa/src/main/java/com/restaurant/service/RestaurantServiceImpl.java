package com.restaurant.service;

import com.restaurant.exceptions.NoRestaurantFoundException;
import com.restaurant.model.Restaurant;
import com.restaurant.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantServiceImpl implements IRestaurantService{
    @Autowired
    IRestaurantRepository restaurantRepository;
    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.getAllRestaurants();
    }

    @Override
    public List<Restaurant> findByNameStarting(String name) throws NoRestaurantFoundException {
        List<Restaurant> restaurants = restaurantRepository.getByNameStarting(name);
        if (restaurants.isEmpty()){
            throw new NoRestaurantFoundException("Restaurant Not Found");
        }
        return restaurants;
    }

    @Override
    public List<Restaurant> findByLocation(String city) throws NoRestaurantFoundException {
        List<Restaurant> restaurants = restaurantRepository.getByLocation(city);
        if (restaurants.isEmpty()){
            throw new NoRestaurantFoundException("Restaurant Not Found");
        }
        return restaurants;
    }

    @Override
    public List<Restaurant> findByType(String type) throws NoRestaurantFoundException {
        List<Restaurant> restaurants = restaurantRepository.getByType(type);
        if (restaurants.isEmpty()){
            throw new NoRestaurantFoundException("Restaurant Not Found");
        }
        return restaurants;
    }

    @Override
    public List<Restaurant> findByItemName(String itemName) throws NoRestaurantFoundException {
        List<Restaurant> restaurants = restaurantRepository.getByItemName(itemName);
        if (restaurants.isEmpty()){
            throw new NoRestaurantFoundException("Restaurant Not Found");
        }
        return restaurants;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.addRestaurant(restaurant);
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        restaurantRepository.deleteRestaurant(restaurantId);
    }
}
