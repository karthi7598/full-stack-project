package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Customer;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.CustomerRepo;
import com.example.service.CustomerService;

@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	public Customer login(String userName, String password) {
		 Customer s = customerRepo.findByUserName(userName);
		 
		 if(s!=null) {
			 if(s.getPassword().equals(password)) {
				 return s;
			 }else {
				throw new ResourceNotFoundException();
			}
		 }else {
			 throw new ResourceNotFoundException();
		 }
	  
	}

	public Customer addCustomer(Customer customer) {
		return  customerRepo.save(customer);
	}

	public Customer updateDb(String userName,Customer customer) {
		
		
		Customer s1 = customerRepo.findByUserName(userName);
		
		if(s1!=null) {
			s1.setPassword(customer.getPassword());
			s1.setMobileNumber(customer.getMobileNumber());   
			s1.setAdress(customer.getAdress());
			
		return customerRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}

	public void deleteDb(String userName) {
	
		
		Customer s2 = customerRepo.findByUserName(userName);
		
		if(s2!=null) {
			customerRepo.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}		 
	}

	
	
}