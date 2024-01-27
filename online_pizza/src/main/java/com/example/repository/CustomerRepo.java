package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query(value =  "select * from Customer where userName =?" , nativeQuery = true)
	Customer findByUserName(String userName);
	

}
