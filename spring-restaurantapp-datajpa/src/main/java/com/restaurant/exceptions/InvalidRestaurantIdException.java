package com.restaurant.exceptions;

public class InvalidRestaurantIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRestaurantIdException() {
		super();
	}

	public InvalidRestaurantIdException(String message) {
		super(message);
	}
	

}
