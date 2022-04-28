package com.restaurant.service;

import com.restaurant.exceptions.NoRestaurantFoundException;
import com.restaurant.model.Restaurant;

import java.util.List;

public interface IRestaurantService {
    List<Restaurant> findAllRestaurants();

    List<Restaurant> findByNameStarting(String name) throws NoRestaurantFoundException;

    List<Restaurant> findByLocation(String city) throws NoRestaurantFoundException;

    List<Restaurant> findByType(String type) throws NoRestaurantFoundException;

    List<Restaurant> findByItemName(String itemName) throws NoRestaurantFoundException; // using joins

    void addRestaurant(Restaurant restaurant);

    void deleteRestaurant(int restaurantId);
}
