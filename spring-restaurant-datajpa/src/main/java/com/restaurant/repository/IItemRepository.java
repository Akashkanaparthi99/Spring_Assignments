package com.restaurant.repository;

import com.restaurant.model.Item;
import com.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IItemRepository extends JpaRepository<Item,Integer> {
    // list of items
    @Query(value = "select * FROM restaurant RIGHT JOIN item ON restaurant.restaurantId = item.restId WHERE restaurant.restaurantId = ?",nativeQuery = true)
    List<Item> getByRestaurantName(int restaurantId) ;
    @Query("from Restaurant r inner join r.items i where r.restaurantId = ?1 and i.category = ?2")
    List<Item> getByCategory(int restaurantId, String category) ;


}
