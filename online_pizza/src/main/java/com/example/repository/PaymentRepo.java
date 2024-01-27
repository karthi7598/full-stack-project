package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Payments;

@Repository
	public interface PaymentRepo extends JpaRepository<Payments, Integer> {

		@Query(value =  "select * from Payment where pId =?" , nativeQuery = true)
		Payments findById(int paymentId);

		
		
		
	
}
