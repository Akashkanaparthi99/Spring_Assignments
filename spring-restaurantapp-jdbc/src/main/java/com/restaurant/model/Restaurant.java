package com.restaurant.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Restaurant {

	private Integer restaurantId;
	private String restaurantName;
	private String city;
	private String type;
	private double rating;

	public Restaurant(String restaurantName, String city, String type, double rating) {
		this.restaurantName = restaurantName;
		this.city = city;
		this.type = type;
		this.rating = rating;
	}
}
