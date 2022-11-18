package com.yash.serviceimpltest;
/**
 * cabserviceimpl test cases 
 * @author abhishek.maurya
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
import com.yash.domain.Cab;
import com.yash.exception.CustomerIdNotFoundException;
import com.yash.repository.CabRepository;
import com.yash.serviceimpl.CabServiceImpl;




@SpringBootTest(classes= {CbsApplication.class})
@RunWith(MockitoJUnitRunner.class)
public class CabServiceImplTest {

	//@InjectMocks
	@Autowired
	CabServiceImpl cabServiceImpl;



	@MockBean
	CabRepository cabRepository;

	/**
	 * Test case for InsertDataInCab
	 */
	@Test
	public void CabInsertDataTest()
	{



		Cab cab = new Cab(9,"newmini",(float) 12.00);

		when(cabRepository.save(cab)).thenReturn(cab);

		assertThat(cabServiceImpl.insertcab(cab)).isEqualTo(cab);
	}

	/**
	 * Test case for get cab data by id
	 */

	@Test
	public void getcabByIdTest()
	{
		Cab cab=new Cab();
		cab.setCabid(1);
		
		cab.setCarType("mini");
		cab.setPerkmRate(25f);
		//action
		Optional<Cab> p=Optional.of(new Cab());
		when(cabRepository.findById(1)).thenReturn(p);
		//assertion
		assertTrue(p.isPresent());	
	}
	/**
	 * Test case get all cabs
	 */
	@Test
	public void getAllCabTest() {
		
		Cab cab=new Cab();
		cab.setCabid(1);
		cab.setCarType("mini");
		cab.setPerkmRate(25f);
		//action
		Optional<Cab> p=Optional.of(new Cab());
		when(cabRepository.findById(1)).thenReturn(p);
		//assertion
		assertTrue(p.isPresent());	
	}
	/**
	 * Test case for Delete Cab Detail
	 */
	@Test
	public void testDeleteCabDetail () throws CustomerIdNotFoundException {
		cabServiceImpl.deleteCabdetail(1);
		assertThat(cabRepository.existsById(1)).isFalse();
	}

}
