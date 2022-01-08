package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter contract data: ");
		System.out.print("Number:");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();

		Contract contract = new Contract(number, date, totalValue);

		ContractService cs = new ContractService(new PaypalService());

		System.out.print("Enter number of installment: ");

		cs.processContract(contract, sc.nextInt());

		for (Installment inst : contract.getInstalmment()) {
			System.out.println(inst);
		}

		sc.close();
	}

}
