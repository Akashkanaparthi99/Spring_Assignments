package com.restaurant.repository;

import com.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {
    // customers
    // List of restaurants
    @Query("from Restaurant r where r.restaurantName like ?1")
    List<Restaurant> getByNameStarting(String name) ;

    @Query("from Restaurant r where r.city = ?1")
    List<Restaurant> getByLocation(String city) ;

    @Query("from Restaurant r where r.type = ?1")
    List<Restaurant> getByType(String type) ;
    @Query("from Restaurant r inner join r.items i where i.itemName = ?1")
    List<Restaurant> getByItemName(String itemName) ; // using joins



}
