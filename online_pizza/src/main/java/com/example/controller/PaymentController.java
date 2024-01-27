package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Payments;
import com.example.service.PaymentService;

@RestController
@CrossOrigin (origins ="http://localhost:4200")
	public class PaymentController {
		
		
	     @Autowired
	     PaymentService  paymentService;
			
			@GetMapping("/payment/{userId}")
			public Payments getPaymentById(@PathVariable int paymentId) {
				return paymentService.getPaymentById(paymentId); 
			}
			
			@PostMapping("/addpayment")
			public Payments addPayment(@RequestBody Payments payment) {
				
				return paymentService.addPayment(payment);
			}
			
			@PutMapping("/updatepayment")
			public Payments update(@RequestHeader int paymentId ,@RequestBody Payments payment) {
				
				return paymentService.updateDb( paymentId ,payment); 
			}
			@DeleteMapping("/deletepayment")
			public String delete(@RequestHeader int paymentId ) {
				paymentService.deleteDb(paymentId );
				return "data deleted";
			}

}
