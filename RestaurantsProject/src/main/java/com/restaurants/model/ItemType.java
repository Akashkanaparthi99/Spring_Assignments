package com.restaurants.model;

public enum ItemType {

	VEG("VEG"),
	NON_VEG("NON VEG");
	public final String type;

	ItemType(String type) {
		this.type = type;
	}
}
