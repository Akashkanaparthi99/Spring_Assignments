package com.restaurants.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurants.model.Restaurant;
import com.restaurants.util.AllQueries;
import com.restaurants.util.ConnectionUtil;

public class RestaurantDaoImpl implements IRestaurantDao {

	static Connection connection;

	@Override
	public List<Restaurant> getAllRestaurants() {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		Restaurant restaurant = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.SELECTQUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("restaurantId");
				String name = resultSet.getString("restaurantName");
				String city = resultSet.getString("city");
				String type = resultSet.getString("type");
				double rating = resultSet.getDouble("rating");
				restaurant = new Restaurant(id, name, city, type, rating);
				restaurants.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ConnectionUtil.closeConnection();
		}
		return restaurants;
	}

	@Override
	public List<Restaurant> getByNameStarting(String name){
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		Restaurant restaurant = null;

		try {
			preparedStatement = connection.prepareStatement(AllQueries.NAMEQUERY);
			preparedStatement.setString(1, name+"%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("restaurantId");
				String city = resultSet.getString("city");
				String type = resultSet.getString("type");
				double rating = resultSet.getDouble("rating");
				String rName = resultSet.getString("restaurantName");
				restaurant = new Restaurant(id, rName, city, type, rating);
				restaurants.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println(restaurants);
		return restaurants;
	}

	@Override
	public List<Restaurant> getByLocation(String city){
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		Restaurant restaurant = null;

		try {
			preparedStatement = connection.prepareStatement(AllQueries.LOCATIONQUERY);
			preparedStatement.setString(1, city);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("restaurantId");
				String name = resultSet.getString("restaurantName");
				String type = resultSet.getString("type");
				double rating = resultSet.getDouble("rating");
				restaurant = new Restaurant(id, name, city, type, rating);
				restaurants.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurants;
	}

	@Override
	public List<Restaurant> getByType(String type){
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		Restaurant restaurant = null;

		try {
			preparedStatement = connection.prepareStatement(AllQueries.TYPEQUERY);
			preparedStatement.setString(1, type);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("restaurantId");
				String name = resultSet.getString("restaurantName");
				String city = resultSet.getString("city");
				double rating = resultSet.getDouble("rating");
				restaurant = new Restaurant(id, name, city, type, rating);
				restaurants.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurants;
	}

	@Override
	public List<Restaurant> getByItemName(String itemName){
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		Restaurant restaurant = null;

		try {
			preparedStatement = connection.prepareStatement(AllQueries.ITEMNAMEQUERY);
			preparedStatement.setString(1, itemName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("restaurantId");
				String name = resultSet.getString("restaurantName");
				String city = resultSet.getString("city");
				String type = resultSet.getString("type");
				double rating = resultSet.getDouble("rating");
				restaurant = new Restaurant(id, name, city, type, rating);
				restaurants.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurants;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.ADDRESTAURANTQUERY);
			preparedStatement.setInt(1, restaurant.getRestaurantId());
			preparedStatement.setString(2, restaurant.getRestaurantName());
			preparedStatement.setString(3, restaurant.getCity());
			preparedStatement.setString(4, restaurant.getType());
			preparedStatement.setDouble(5, restaurant.getRating());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ConnectionUtil.closeConnection();
		}
		if (result != 0) {
			System.out.println("Restaurant Data is successfully added...!!");
		} else {
			System.err.println("Restaurant Data is not added...");
		}
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.DELETERESTAURANTQUERY);
			preparedStatement.setInt(1, restaurantId);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ConnectionUtil.closeConnection();
		}
		if (result != 0) {
			System.out.println("Restaurant is Deleted Successfully.....!!");
		} else {
			System.err.println("Delete Operation is Failed...");
		}

	}

}
