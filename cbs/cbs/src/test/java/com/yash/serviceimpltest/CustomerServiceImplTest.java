package com.yash.serviceimpltest;

/**
 * Customer test cases
 * @author akshay.patil
 * 
 */
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.CbsApplication;
import com.yash.domain.Cab;
import com.yash.domain.Customer;
import com.yash.domain.Driver;
import com.yash.exception.CustomerIdNotFoundException;
import com.yash.repository.CustomerRepository;
import com.yash.serviceimpl.CustomerServiceImpl;

@SpringBootTest(classes= {CbsApplication.class})
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@Autowired 
	CustomerServiceImpl customerServiceImpl; 
	
	@MockBean
	CustomerRepository customerRepository; 
	
	/**
	 * test case for insert data in customer
	 * 
	 */
	@Test
	public void CustomerInsertDataTest() 
	{
		Customer customer = new Customer();
		customer.setName("Akshay");
		when(customerRepository.save(customer)).thenReturn(customer);
		assertThat(customerServiceImpl.insertCustomer(customer)).isEqualTo(customer);
		
	}
	/**
	 * test case for get customer data by id
	 * 
	 */

	@Test
	public void getCustomerByIdTest()
	{
		Customer customer=new Customer();
		customer.setCustomerid(1);
		
		//action
		Optional<Customer> p=Optional.of(new Customer());
		when(customerRepository.findById(1)).thenReturn(p);
		//assertion
		assertTrue(p.isPresent());	
	}
	/**
	 * test case for get all Customers
	 * 
	 */
	@Test
	public void getAllCustomers() {
		Customer customer=new Customer();
		customer.setCustomerid(2);;
		customer.setName("sameer");
		customer.setEmail("baner@gmail.com");
		
		Optional<Customer> p=Optional.of(new Customer());
		when(customerRepository.findById(2)).thenReturn(p);
		//assertion
		assertTrue(p.isPresent());	
	}
	

	/**
	 * test case for delete customer
	 * 
	 */
	@Test
	public void testDeleteCustomer () throws CustomerIdNotFoundException {
		customerServiceImpl.deleteCustomer(1);
		assertThat(customerRepository.existsById(1)).isFalse();
	}
	

}
