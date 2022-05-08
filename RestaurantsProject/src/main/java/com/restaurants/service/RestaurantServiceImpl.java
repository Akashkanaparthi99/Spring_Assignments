package com.restaurants.service;

import java.util.List;
import java.util.stream.Collectors;

import com.restaurants.exceptions.NoRestaurantFoundException;
import com.restaurants.model.Restaurant;
import com.restaurants.repository.IRestaurantDao;
import com.restaurants.repository.RestaurantDaoImpl;

public class RestaurantServiceImpl implements IRestaurantService {

	IRestaurantDao restaurantDao = new RestaurantDaoImpl();
	@Override
	public List<Restaurant> findAllRestaurants() {
		return restaurantDao.getAllRestaurants().stream().sorted((r1, r2) ->r1.getRestaurantName().compareTo(r2.getRestaurantName())).collect(Collectors.toList());
	}

	@Override
	public List<Restaurant> findByNameStarting(String name) throws NoRestaurantFoundException {
		List<Restaurant> nameStarting = restaurantDao.getByNameStarting(name);
		if (nameStarting.isEmpty()) {
			throw new NoRestaurantFoundException("No Restaurant is Found with name starting - "+name);
		}
		return nameStarting.stream().collect(Collectors.toList());
	}

	@Override
	public List<Restaurant> findByLocation(String city) throws NoRestaurantFoundException {
		List<Restaurant> location = restaurantDao.getByLocation(city);
		if (location.isEmpty()) {
			throw new NoRestaurantFoundException("No Restaurant is Found in loaction - "+location);
		}
		return location.stream().sorted((o1, o2) -> o1.getRestaurantName().compareTo(o2.getRestaurantName())).collect(Collectors.toList());
	}

	@Override
	public List<Restaurant> findByType(String type) throws NoRestaurantFoundException {
		List<Restaurant> byType = restaurantDao.getByType(type);
		if (byType.isEmpty()) {
			throw new NoRestaurantFoundException("No Restaurant is Found with Type - "+type);
		}
		return byType.stream().sorted((o1, o2) -> o1.getRestaurantName().compareTo(o2.getRestaurantName())).collect(Collectors.toList());
	}

	@Override
	public List<Restaurant> findByItemName(String itemName) throws NoRestaurantFoundException {
		List<Restaurant> item = restaurantDao.getByItemName(itemName);
		if (item.isEmpty()) {
			throw new NoRestaurantFoundException("No Restaurant is Found with Type - "+itemName);
		}
		return item.stream().sorted((o1, o2) -> o1.getRestaurantName().compareTo(o2.getRestaurantName())).collect(Collectors.toList());
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		restaurantDao.addRestaurant(restaurant);

	}

	@Override
	public void deleteRestaurant(int restaurantId){
		restaurantDao.deleteRestaurant(restaurantId);

	}

}
