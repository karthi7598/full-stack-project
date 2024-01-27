package com.example.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Payments;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.PaymentRepo;
import com.example.service.PaymentService;

@Service
public class PaymentImpl implements PaymentService{

	@Autowired
	PaymentRepo paymentRepo;
	
	public Payments getPaymentById(int paymentId ) {
		Optional<Payments> pay=Optional.ofNullable(paymentRepo.findById(paymentId));

		Payments p;
		if(pay.isPresent())
       {

			 p=pay.get();

		}

else {

			throw new ResourceNotFoundException();

		}

		return p;

}

	@Override
	public Payments addPayment(Payments payment) {
		return  paymentRepo.save(payment);
	}

	@Override
	public Payments updateDb(int paymentId, Payments payment) {
	Payments s1 = paymentRepo.findById(paymentId);
	if(s1!=null) {
		s1.setUser_id(payment.getUser_id());   
		s1.setPaymentMode(payment.getPaymentMode());
		s1.setTotalPrice(payment.getTotalPrice());
	return paymentRepo.save(s1);
	} 
	else 
	{
		throw new ResourceNotFoundException();
	} 
}

public void deleteDb(int paymentId) {

	
	Payments s2 = paymentRepo.findById(paymentId);

	if(s2!=null) {
		paymentRepo.delete(s2);
	}
	else {
		throw new ResourceNotFoundException();
	}		 




}
}


