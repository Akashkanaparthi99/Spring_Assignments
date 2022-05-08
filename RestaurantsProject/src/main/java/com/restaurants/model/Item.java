package com.restaurants.model;

public class Item {

	private Integer itemId;
	private String itemName;
	private String itemType; // this will be saved as string by taking the valude from the enum
	private double price;
	private String category; // this will be saved as enum
	private Integer restId;
	public Item() {
		super();
	}


	public Integer getRestId() {
		return restId;
	}


	public void setRestId(Integer restId) {
		this.restId = restId;
	}


	public Item(Integer itemId, String itemName, String itemType, double price, String category, Integer restId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.price = price;
		this.category = category;
		this.restId = restId;
	}


	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemType=" + itemType + ", price=" + price + ", category=" + category
				+ "]";
	}

}
