package com.yash.exception;

/**
 * handle Exception by user define;
 * if cab  ID not found then this exception occured;
 * @author abhishek.maurya
 *
 */
public class CabIdException extends RuntimeException  {
	
	private static final long serialVersionUID = 1L;

	public CabIdException(String msg)
	{
		super(msg);
	}

	

}
