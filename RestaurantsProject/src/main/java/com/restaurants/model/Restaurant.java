package com.restaurants.model;

public class Restaurant {

	private Integer restaurantId;
	private String restaurantName;
	private String city;
	private String type;
	private double rating;

	public Restaurant() {
		super();
	}

	public Restaurant(Integer restaurantId, String restaurantName, String city, String type, Double rating) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.city = city;
		this.type = type;
		this.rating = rating;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantName=" + restaurantName + ", city=" + city + ", type=" + type + ", rating="
				+ rating + "]";
	}

}
