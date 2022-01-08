package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	
	private Integer number;
	private Date date;
	private Double totalValue;
	
	private List<Installment> installments = new ArrayList<Installment>();
	
	public Contract() {
		
	}
	
	public Contract(int number, Date date, Double totalValue ) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getTotalValue() {
		return totalValue;
	}
	
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	public List<Installment> getInstalmment(){
		return installments;
	}
		
	public void listAdd(Installment installment) {
		installments.add(installment);
	}
	
	public void listRemove(Installment installment) {
		installments.add(installment);
	}
	
}
