package com.restaurant.exceptions;

public class NoRestaurantFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoRestaurantFoundException() {
		super();
	}

	public NoRestaurantFoundException(String message) {
		super(message);
	}
	

}
