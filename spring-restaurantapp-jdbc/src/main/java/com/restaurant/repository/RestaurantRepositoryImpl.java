package com.restaurant.repository;

import com.restaurant.model.Restaurant;
import com.restaurant.util.AllQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RestaurantRepositoryImpl implements IRestaurantRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Restaurant> getAllRestaurants() {

       return jdbcTemplate.query(AllQueries.SELECTQUERY,(rs, rowNum) -> {
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantId(rs.getInt("restaurantId"));
            restaurant.setRestaurantName(rs.getString("restaurantName"));
            restaurant.setRating(rs.getDouble("rating"));
            restaurant.setType(rs.getString("type"));
            restaurant.setCity(rs.getString("city"));
            return restaurant;
        });

    }

    @Override
    public List<Restaurant> getByNameStarting(String name) {
        return jdbcTemplate.query(AllQueries.NAMEQUERY,new RestaurantMapper(),"%"+name+"%");
    }

    @Override
    public List<Restaurant> getByLocation(String city) {
        return jdbcTemplate.query(AllQueries.LOCATIONQUERY,new RestaurantMapper(),
                city);
    }

    @Override
    public List<Restaurant> getByType(String type) {
        return jdbcTemplate.query(AllQueries.TYPEQUERY,new RestaurantMapper()
        ,type);
    }

    @Override
    public List<Restaurant> getByItemName(String itemName) {
        return jdbcTemplate.query(AllQueries.ITEMNAMEQUERY,new RestaurantMapper(),itemName);
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        Object[] restaurantList = {
                restaurant.getRestaurantId(),restaurant.getRestaurantName(),restaurant.getCity(),
                restaurant.getType(),restaurant.getRating()
        };
        jdbcTemplate.update(AllQueries.ADDRESTAURANTQUERY,restaurantList);
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        jdbcTemplate.update(AllQueries.DELETERESTAURANTQUERY,restaurantId);
    }
}
