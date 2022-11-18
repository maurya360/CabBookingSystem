package com.yash.exception;

/**
 * handle Exception by user define;
 * if customer record  not found then this exception occured;
 * @author akshay.patil
 *
 */

public class RecordNotFoundException extends Exception
{
	
	public RecordNotFoundException(String msg) 
	{
		super(msg);
	}
}
