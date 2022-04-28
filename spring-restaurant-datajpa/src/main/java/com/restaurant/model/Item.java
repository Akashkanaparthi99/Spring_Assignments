package com.restaurant.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Item")
public class Item {
	@Id
	@GeneratedValue(generator = "item_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "item_gen",sequenceName = "item_sequence",initialValue = 1,allocationSize = 10)
	private Integer itemId;
	@Column(length = 30)
	private String itemName;
	@Column(length = 30)
	private String itemType; // this will be saved as string by taking the valude from the enum
	@Column(length = 30)
	private double price;
	@Column(length = 30)
	private String category; // this will be saved as enum


	public Item(String itemName, String itemType, double price, String category) {
		this.itemName = itemName;
		this.itemType = itemType;
		this.price = price;
		this.category = category;
	}
}
