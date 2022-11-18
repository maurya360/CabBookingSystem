package com.yash.web;
/**
 * admin controller
 * @author usha.more mujeeba.khan samuel.daniel
 */

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yash.domain.AbstractUser;
import com.yash.domain.Admin;
import com.yash.domain.TripBooking;
import com.yash.exception.InvalidData;
import com.yash.serviceimpl.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminServiceImpl;
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/*
	 * admin login mapping
	 * 
	 */
	@PostMapping("/login")
	public Admin adminLogin(Admin admin,HttpSession session) throws InvalidData {
		logger.trace("admin data recived"+admin.getEmail()+admin.getPassword());
		Admin fromAdminServ=adminServiceImpl.requestLogin(admin.getEmail(),admin.getPassword());
		logger.trace("recevied the valid or null data"+fromAdminServ);
		if (fromAdminServ!=null) {
			session.setAttribute("AdminSession", fromAdminServ);
			
			return fromAdminServ;
		} else {
			return new Admin();
		}
		
	}
	
	/**
	 * admin logout 
	 * 
	 */
	@PostMapping("/logout")
	public String adminLogout(HttpSession session) {
		if (session!=null) {
			session.getAttribute("AdminSession");
			session.invalidate();
		} 
		return "Session Expired";
	}
	
	/*
	 * saveadmin
	 */
	@PostMapping("/saveadmin")
	public ResponseEntity<?> saveAdmin(@RequestBody Admin a) 
	{
		Admin admin = adminServiceImpl.saveOrUpdate(a);
		return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
	}
	
	/*
	 * update admin details
	 */
	@PutMapping("/updateadmin") // http://localhost/8081/cbs/admin/updateadmin
	public ResponseEntity<?> updateAdmin(@RequestBody Admin a) 
	{
		Admin admin = adminServiceImpl.saveOrUpdate(a);
		return new ResponseEntity<Admin>(admin, HttpStatus.CREATED);
	}
	
	/*
	 * get admin details
	 */
	@GetMapping("/getadmin")  // http://localhost/8081/cbs/admin/getadmin
	public List<Admin> getAdmin()
	{
		List<Admin> list = adminServiceImpl.getAdmin();
		return list;
	}
	
	//@DeleteMapping("/deleteadmin/{id}")
	//public ResponseEntity<?> deleteAdmin(@PathVariable("id") int id )
	/*
	 * delete admin details
	 */
	@DeleteMapping("/deleteadmin") // http://localhost/8081/cbs/admin/deleteadmin
	public ResponseEntity<?> deleteAdmin(Admin admin)
	{
		int id = admin.getAdminid();
		adminServiceImpl.deleteAdmin(id);
		return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT);
	}
	
	/*
	 * get all trips 
	 */
	@GetMapping("/getalltrips") // http://localhost/8081/cbs/admin/getalltrips
	public List<TripBooking> getAllTrips() {
		List<TripBooking> list = adminServiceImpl.getAllTrips();
		return list;
	}
	
	/*
	 * get trips datewise 
	 */
	@PostMapping("/gettripsdatewise") // http://localhost/8081/cbs/admin/gettripsdatewise
	public List<TripBooking> getTripsDateWise() {
		List<TripBooking> list = adminServiceImpl.getTripsDateWise();
		return list;
	}
	/*
	 * get trips for days
	 */
	@PostMapping("/gettripsfordays") // http://localhost/8081/cbs/admin/gettripsfordays
	public List<TripBooking> getTripsForDays(TripBooking tb) {
		int customerId = tb.getCustomer().getCustomerid();
		Date fromDate = tb.getFromDateTime();
		Date toDate = tb.getToDateTime();
		List<TripBooking> list = adminServiceImpl.getAllTripsForDays(customerId, fromDate, toDate);
		return list;
	}
	
	/*
	 * get trips cab wise
	 */
	@GetMapping("/gettripscabwise") // http://localhost/8081/cbs/admin/gettripscabwise
	public List<TripBooking> getTripsCabWise()
	{
		List<TripBooking> list = adminServiceImpl.getTripsCabWise();
		return list;
	}
	
	/*
	 * get trips customer wise
	 */
	@GetMapping("/gettripscustomerwise") // http://localhost/8081/cbs/admin/gettripscustomerwise
	public List<TripBooking> getTripsCustomerWise(TripBooking tb)
	{
		int customerId = tb.getCustomer().getCustomerid();
		List<TripBooking> list = adminServiceImpl.getTripsCustomerWise(customerId);
		return list;
	}
	
}
