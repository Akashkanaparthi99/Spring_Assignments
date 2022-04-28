package com.restaurant.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {

	private Integer itemId;
	private String itemName;
	private String itemType; // this will be saved as string by taking the valude from the enum
	private double price;
	private String category; // this will be saved as enum
	private Integer restId;

	public Item(String itemName, String itemType, double price, String category) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.price = price;
		this.category = category;
	}


}
