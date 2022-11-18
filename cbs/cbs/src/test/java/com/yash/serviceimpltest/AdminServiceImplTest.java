package com.yash.serviceimpltest;


/**
 * Admin Test cases class
 * @author usha.more mujeeba.khan samuel.Daniel
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
import com.yash.domain.Admin;
import com.yash.domain.TripBooking;
import com.yash.exception.CustomerIdNotFoundException;
import com.yash.repository.AdminRepository;

import com.yash.serviceimpl.AdminServiceImpl;


@SpringBootTest(classes= {CbsApplication.class})
@RunWith(MockitoJUnitRunner.class)
public class AdminServiceImplTest 
{

	@Autowired 
	AdminServiceImpl adminServiceImpl; 
	
	@MockBean
	AdminRepository adminRepository; 
	
	/**
	 * test case for insert data in admin
	 * 
	 */
	@Test
	public void AdminInsertDataTest() 
	{
		Admin admin = new Admin(1);	
		when(adminRepository.save(admin)).thenReturn(admin);
		assertThat(((AdminServiceImpl) adminServiceImpl).saveOrUpdate(admin)).isEqualTo(admin);
		
		}
	
	/**
	 * test case for get admin data 
	 * 
	 */
	@Test
	public void getAdminTest()
	{
		Admin admin=new Admin();
		admin.setAdminid(1);
		admin.setName("aaa");
		admin.setEmail("a@gmail.com");
		admin.setPassword("password99");
			//action
			Optional<Admin> p=Optional.of(new Admin());
			when(adminRepository.findById(1)).thenReturn(p);
			//assertion
			assertTrue(p.isPresent());	
		
	}
	/**
	 * test case for delete admin data
	 * 
	 */
	@Test
	public void testDeleteAdmin () throws CustomerIdNotFoundException {
		adminServiceImpl.deleteAdmin(1);;
		assertThat(adminRepository.existsById(1)).isFalse();
	}

}
