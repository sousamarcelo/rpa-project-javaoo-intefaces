package model.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private PaymentService paymentService;
	
	public ContractService() {
		
	}
	
	public ContractService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	public void processContract(Contract contract, Integer month) {
		double basicQuota = contract.getTotalValue() / month;
		for(int i = 1; i <= month; i++) {
			double updatedQuota = basicQuota + paymentService.interest(basicQuota, i);	
			double fullQuota = updatedQuota + paymentService.paymentFee(updatedQuota);
			
			Date date = addMonthy(contract.getDate(), i);
			
			contract.getInstalmment().add(new Installment(date, fullQuota));			
		}
		
	}
	
	public Date addMonthy(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}
