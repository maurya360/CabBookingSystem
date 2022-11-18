package com.yash.service;

/**
 * Admin Service Methods
 * Interface having declaration of all the service methods of TripBooking
 * @author usha.more mujeeba.khan samuel.daniel 
 * 
 */

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.yash.domain.TripBooking;

public interface AdminService 
{	
	/*
	 * this getAllTrips method is used for getting all records from table trip_booking
	 */
	public List<TripBooking> getAllTrips();
	
	/*
	 * this getTripsCabWise method is used for getting trip records cabwise from table trip_booking
	*/
	public List<TripBooking> getTripsCabWise();
	
	/*
	 * this getTripsCustomerWise method is used for getting trips records customerwise from table trip_booking
	 */
	public List<TripBooking> getTripsCustomerWise(int customerId);
	
	/*
	 * this  getTripsDateWise method is used for getting trips records datewise from table trip_booking
	 */
	public List<TripBooking> getTripsDateWise();
	
	/*
	 * this getAllTripsForDays method is used for getting all  trip records  for days from table trip_booking
	 */
	public List<TripBooking> getAllTripsForDays(int customerId, Date fromDate, Date toDate);
}
 

