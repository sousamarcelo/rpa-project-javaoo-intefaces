package model.service;

public class PaypalService implements PaymentService {
	
	private final static double TAX = 0.02;
	private final static double INTEREST = 0.01;

	@Override
	public double paymentFee(Double amount) {
		
		return amount*TAX;
	}

	@Override
	public double interest(Double amout, Integer month) {
		return month * amout * INTEREST;		
	}	

}
