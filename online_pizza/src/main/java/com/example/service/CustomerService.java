package com.example.service;

import com.example.entities.Customer;

public interface CustomerService { 
	Customer login(String userName, String password );


	Customer addCustomer(Customer cus);

	Customer updateDb(String userName,Customer cus);

	void deleteDb(String userName);
}