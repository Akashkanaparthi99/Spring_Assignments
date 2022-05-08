package com.restaurants.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurants.model.Item;
import com.restaurants.util.AllQueries;
import com.restaurants.util.ConnectionUtil;

public class ItemDaoImpl implements IItemsDao {

	static Connection connection;

	@Override
	public List<Item> getByRestaurantName(int restaurantId) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Item> items = new ArrayList<Item>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.ITEMLISTQUERY);
			preparedStatement.setInt(1, restaurantId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				items.add(new Item(resultSet.getInt("itemId"), resultSet.getString("itemName"),
						resultSet.getString("type"), resultSet.getDouble("price"), resultSet.getString("category"),
						resultSet.getInt("restId")));
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
		return items;
	}

	@Override
	public List<Item> getByCategory(int restaurantId, String category) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Item> items = new ArrayList<Item>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.CATEGORYQUERY);
			preparedStatement.setString(1, category);
			preparedStatement.setInt(2, restaurantId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				items.add(new Item(resultSet.getInt("itemId"), resultSet.getString("itemName"),
						resultSet.getString("type"), resultSet.getDouble("price"), resultSet.getString("category"),
						resultSet.getInt("restId")));
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

		return items;
	}

	@Override
	public void addItems(Item item) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.ADDQUERY);
			preparedStatement.setInt(1, item.getItemId());
			preparedStatement.setString(2, item.getItemName());
			preparedStatement.setString(3, item.getItemType());
			preparedStatement.setDouble(4, item.getPrice());
			preparedStatement.setString(5, item.getCategory());
			preparedStatement.setInt(6, item.getRestId());
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
			System.out.println("ITEM ADDED SUCCESSFULLY");
		} else {
			System.err.println("FAILED TO ADD ITEM");
		}
	}

	@Override
	public void updateItem(int itemId, double price) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.UPDATEQUERY);
			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, itemId);
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
			System.out.println("ITEM PRICE IS SUCCESSFULLY UPDATED ");
		} else {
			System.err.println("UPDATING FAILED");
		}
	}

	@Override
	public void deleteItem(int itemId) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.DELETEQUERY);
			preparedStatement.setInt(1, itemId);
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
			System.out.println("ITEM HAS BEEN DELETED SUCCESFULLY");
		} else {
			System.err.println("ITEM HAS NOT DELETED");
		}

	}

}
