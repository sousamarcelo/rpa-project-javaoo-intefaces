package model.service;

public interface PaymentService {
	
	double paymentFee(Double amount);
	
	double interest(Double amout, Integer month);
}
