package com.restaurant.repository;

import com.restaurant.model.Restaurant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantMapper implements RowMapper<Restaurant> {
    @Override
    public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(rs.getInt("restaurantId"));
        restaurant.setRestaurantName(rs.getString("restaurantName"));
        restaurant.setRating(rs.getDouble("rating"));
        restaurant.setType(rs.getString("type"));
        restaurant.setCity(rs.getString("city"));
        return restaurant;
    }
}
