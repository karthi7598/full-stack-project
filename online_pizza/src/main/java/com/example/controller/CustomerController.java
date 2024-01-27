package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Customer;
import com.example.service.CustomerService;

@RestController
@CrossOrigin (origins ="http://localhost:4200")
	public class CustomerController {

		@Autowired
		CustomerService customerService;
		
		@GetMapping("/login")
		public Customer login(@RequestHeader String userName ,@RequestHeader String password) {
			return customerService.login(userName,password); 
		}
		
		@PostMapping("/post")
		public Customer addCustomer(@RequestBody Customer customer) {
			
			return customerService.addCustomer(customer);
		}
		
		@PutMapping("/update")
		public Customer update(@RequestHeader String userName ,@RequestBody Customer customer) {
			
			return customerService.updateDb(userName,customer); 
		}
		@DeleteMapping("/delete")
		public String delete(@RequestHeader String userName) {
			customerService.deleteDb(userName);
			return "data deleted";
		}
}
