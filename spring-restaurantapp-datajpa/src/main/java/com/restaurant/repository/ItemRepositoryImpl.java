package com.restaurant.repository;

import com.restaurant.model.Item;
import com.restaurant.util.AllQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements IItemRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Item> getByRestaurantName(int restaurantId) {
        return jdbcTemplate.query(AllQueries.ITEMLISTQUERY, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                Item item = new Item();
                item.getItemId(rs.getInt("itemId"));
                item.getItemName(rs.getString("itemName"));
                item.getItemType(rs.getString("type"));
                item.getPrice(rs.getDouble("price"));
                item.getCategory(rs.getString("category"));
                item.getRestId(rs.getInt("restId"));
                return item;
            }
        }, restaurantId);

    }

    @Override
    public List<Item> getByCategory(int restaurantId, String category) {
        return jdbcTemplate.query(AllQueries.CATEGORYQUERY, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                Item item = new Item();
                item.getItemId(rs.getInt("itemId"));
                item.getItemName(rs.getString("itemName"));
                item.getItemType(rs.getString("type"));
                item.getPrice(rs.getDouble("price"));
                item.getCategory(rs.getString("category"));
                item.getRestId(rs.getInt("restId"));
                return item;
            }
        }, category, restaurantId);
    }

    @Override
    public void addItems(Item item) {
        Object[] items = {item.getItemId(), item.getItemName(), item.getItemType(),
                item.getCategory(), item.getPrice(), item.getRestId()};
        jdbcTemplate.update(AllQueries.ADDQUERY, items);
    }

    @Override
    public void updateItem(int itemId, double price) {
        jdbcTemplate.update(AllQueries.UPDATEQUERY, price, itemId);
    }

    @Override
    public void deleteItem(int itemId) {
        jdbcTemplate.update(AllQueries.DELETEQUERY, itemId);
    }
}
