package com.yash.exception;

/**
 * handle Exception by user define;
 * if customer Name not  and invalid input taken by user  then this exception occured;
 * @author akshay.patil
 *
 */


public class InvalidNameException extends Exception
{

	public InvalidNameException(String msg) 
	{
		super(msg);
	}
}
