package com.restaurants.service;

import java.util.List;

import com.restaurants.exceptions.NoRestaurantFoundException;
import com.restaurants.model.Restaurant;



public interface IRestaurantService {

	List<Restaurant> findAllRestaurants();

	List<Restaurant> findByNameStarting(String name) throws NoRestaurantFoundException;

	List<Restaurant> findByLocation(String city) throws NoRestaurantFoundException;

	List<Restaurant> findByType(String type) throws NoRestaurantFoundException;

	List<Restaurant> findByItemName(String itemName) throws NoRestaurantFoundException; // using joins

	void addRestaurant(Restaurant restaurant);

	void deleteRestaurant(int restaurantId);



}
