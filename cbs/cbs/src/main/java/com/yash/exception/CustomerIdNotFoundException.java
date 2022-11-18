package com.yash.exception;


/**
 * handle Exception by user define;
 * if customer ID not found then this exception occured;
 * @author akshay.patil
 *
 */

public class CustomerIdNotFoundException extends Exception
{

	public CustomerIdNotFoundException(String msg) 
	{
		super(msg);
	}

}
