package com.yash.exception;
/**
 * handle Exception by user define;
 * if trip ID not found then this exception occured;
 * @author usha.more mujeeba.khan samuel.daniel 
 *
 */


public class TripIdException extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TripIdException(String string) {
		super(string);
	}
}
