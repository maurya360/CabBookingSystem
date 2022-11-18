package com.yash.exception;

/**
 * handle Exception by user define;
 * if data is invalid then this exception occured;
 * @author usha.more mujeeba.khan samuel.daniel 
 *
 */
public class InvalidData extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidData(String string) {
		super(string);
		
	}
}
