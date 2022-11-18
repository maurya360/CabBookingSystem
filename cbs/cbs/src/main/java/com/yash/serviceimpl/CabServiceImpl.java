package com.yash.serviceimpl;
/**
 * cabServiseImpl class 
 * @author abhishek.maurya
 * 
 */

import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.domain.Cab;
import com.yash.exception.CabIdException;
import com.yash.repository.CabRepository;


@Service
public class CabServiceImpl
{

	Logger logger= Logger.getAnonymousLogger();

	@Autowired
	CabRepository cabrepository;
	
	/*
	 * insert cab 
	 */
	public Cab insertcab(Cab cab)
	{
		try {
		return cabrepository.save(cab);	
		}catch(Exception c)
		{
			c.printStackTrace();
		}
		return cab;
	}
	
	/*
	 * cab detail delete by id 
	 */
	public Cab deleteCabdetail(int id)
	{
		try {
		cabrepository.deleteById(id);
		}catch(Exception c)
		{
			throw new CabIdException("ID NOT FOUND");
		}
		return null;
		
	}
	
	
	/*
	 * show type of cabs 
	 */
	public Set<Cab> viewcabsOfTypes(String carType) {
		try {
			Set<Cab> cablistCabs= cabrepository.viewcabsOfTypes(carType);
			return cablistCabs;	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * get count of cabs by its type
	 */
	public int countCabsOfType(String carType)
	{
		return cabrepository.viewcabsOfTypes(carType).size();
		
	}



}
