package com.yash.serviceimpltest;

/**
 * Customer test cases
 * @author anuj.agarwal
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
import com.yash.repository.DriverRepository;
import com.yash.serviceimpl.DriverServiceImpl;

@SpringBootTest(classes= {CbsApplication.class})
@RunWith(MockitoJUnitRunner.class)
public class DriverServiceImplTest {

	@Autowired 
	DriverServiceImpl driverServiceImpl; 
	
	@MockBean
	DriverRepository driverRepository; 
	
	/**
	 * test case for insert data in driver
	 * 
	 */
	@Test
	public void DriverInsertDataTest() 
	{
		Driver driver = new Driver(1, "aaa", null, 4.5f);
		when(driverRepository.save(driver)).thenReturn(driver);
		assertThat(driverServiceImpl.registerAndUpdateDriver(driver)).isEqualTo(driver);
		
	}

}
