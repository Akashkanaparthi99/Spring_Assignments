package com.restaurant.repository;

import com.restaurant.model.Restaurant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantMapper implements RowMapper<Restaurant> {
    @Override
    public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.getRestaurantId(rs.getInt("restaurantId"));
        restaurant.getRestaurantName(rs.getString("restaurantName"));
        restaurant.getRating(rs.getString("rating"));
        restaurant.getType(rs.getString("type"));
        restaurant.getCity(rs.getString("city"));
        return restaurant;
    }
}
