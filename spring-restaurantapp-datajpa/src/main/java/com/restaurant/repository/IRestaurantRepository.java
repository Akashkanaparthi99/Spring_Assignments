package com.restaurant.repository;

import com.restaurant.model.Restaurant;

import java.util.List;

public interface IRestaurantRepository {
    // customers
    // List of restaurants
    List<Restaurant> getAllRestaurants();

    List<Restaurant> getByNameStarting(String name) ;

    List<Restaurant> getByLocation(String city) ;

    List<Restaurant> getByType(String type) ;

    List<Restaurant> getByItemName(String itemName) ; // using joins

    // Admin

    void addRestaurant(Restaurant restaurant);

    void deleteRestaurant(int restaurantId) ;

}
