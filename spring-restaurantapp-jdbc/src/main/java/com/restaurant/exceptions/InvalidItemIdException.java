package com.restaurant.exceptions;

public class InvalidItemIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidItemIdException() {
		super();
	}

	public InvalidItemIdException(String message) {
		super(message);
	}
	

}
