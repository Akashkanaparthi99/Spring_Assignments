package com.restaurants.repository;

import java.util.List;

import com.restaurants.model.Restaurant;

public interface IRestaurantDao {
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
