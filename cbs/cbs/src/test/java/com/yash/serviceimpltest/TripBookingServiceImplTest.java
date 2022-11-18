package com.yash.serviceimpltest;
/**
 * TripBooking Test Cases
 * @author usha.more mujeeba.khan samuel.daniel
 * 
 */
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.CbsApplication;
import com.yash.domain.Customer;
import com.yash.domain.Driver;
import com.yash.domain.TripBooking;
import com.yash.repository.CustomerRepository;
import com.yash.repository.TripBookingRepository;
import com.yash.serviceimpl.CustomerServiceImpl;
import com.yash.serviceimpl.TripBookingServiceImpl;

@SpringBootTest(classes= {CbsApplication.class})
@RunWith(MockitoJUnitRunner.class)
public class TripBookingServiceImplTest 
{

	@Autowired 
	TripBookingServiceImpl tripBookingServiceImpl; 
	
	@MockBean
	TripBookingRepository tripBookingRepository; 
	
	/**
	 * test case for insert data in customer
	 * @param customer 
	 * 
	 */
	@Test
	public void TripBookingInsertDataTest() 
	{
		
		TripBooking tripbook = new TripBooking();
		tripbook.setTripBookingId(1);
		tripbook.setCustomer(null);
		tripbook.setDriver(null);
		tripbook.setFromLocation("Pune");
		tripbook.setToLocation("delhi");
		tripbook.setFromDateTime(null);
		tripbook.setToDateTime(null);
		tripbook.setStatus(false);
		tripbook.setDistanceInKm(13f);
		tripbook.setBill(250f);
		when(tripBookingRepository.save(tripbook)).thenReturn(tripbook);
		assertThat(tripBookingServiceImpl.registerOrUpdateCustomerBooking(tripbook, null)).isEqualTo(tripbook);
		
		}

	/**
	 * test case get trip data by id
	 * @param customer 
	 * 
	 */

	@Test
	public void getTripByIdTest()
	{
		TripBooking tripBooking =new TripBooking();
		tripBooking.setTripBookingId(101);
		
		//action
		Optional<TripBooking> p=Optional.of(new TripBooking());
		when(tripBookingRepository.findById(101)).thenReturn(p);
		//assertion
		assertTrue(p.isPresent());	
	}
}
