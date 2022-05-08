package com.restaurants.util;

public class AllQueries {

	//restaurant 
	public static final String SELECTQUERY = "select * from restaurant";
	public static final String NAMEQUERY = "select * from restaurant where restaurantName like ?";
	public static final String LOCATIONQUERY = "select * from restaurant where city = ?";
	public static final String TYPEQUERY = "select * from restaurant where type = ?";
	public static final String ITEMNAMEQUERY = "select * FROM restaurant LEFT JOIN item ON restaurant.restaurantId = item.restId WHERE item.itemName = ?";
	public static final String ADDRESTAURANTQUERY = "insert into restaurant values(?,?,?,?,?)";
	public static final String DELETERESTAURANTQUERY = "delete from restaurant where restaurantId =?";
	
	//items
	public static final String ITEMLISTQUERY = "select * FROM restaurant RIGHT JOIN item ON restaurant.restaurantId = item.restId WHERE restaurant.restaurantId = ?";
	public static final String CATEGORYQUERY = "select * FROM item WHERE category = ? GROUP BY restId = ?";
	public static final String ADDQUERY = "insert into item values(?,?,?,?,?,?)";
	public static final String UPDATEQUERY = "update item set price = ? where itemId = ?";
	public static final String DELETEQUERY = "delete from where itemId = ?";
	
	
}
