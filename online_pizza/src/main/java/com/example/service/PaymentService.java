package com.example.service;

import com.example.entities.Payments;

public interface PaymentService {
		Payments getPaymentById(int paymentId );
		Payments addPayment(Payments payment);
		Payments updateDb(int paymentId, Payments payment);
		void deleteDb(int paymentId);
		
	}

