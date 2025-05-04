package MiniBank;

import java.util.Scanner;

public class BankInterface {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankingSystem bankingSystem = null;
		int option;
		do {
		System.out.println("Select a Service: \n1.Create Account\n2.Deposit\n3.Withdraw"
				+ "\n4.View details\n5.Exit");
		 option= scanner.nextInt();
		switch (option) {
		case 1: {
			System.out.println("Enter your name: ");
			String name=scanner.next();
			
			System.out.println("Enter Account no.");
			String acNo=scanner.next();
			
			System.out.println("Deposit Initial Amount");
			int depAmount = scanner.nextInt();
			 bankingSystem= new BankingSystem(name, acNo, depAmount);
			 System.out.println("Account Successfully created");
			break;
		}
		case 2:{
			System.out.println("Enter Amount to Deposit");
			Double dep=scanner.nextDouble();
			bankingSystem.deposit(dep);
			break;
		}
		case 3:{
			System.out.println("Enter Amount to withdraw");
			Double with=scanner.nextDouble();
			bankingSystem.withdraw(with);
			break;
		}
		case 4:{
			bankingSystem.getDetails();
			break;
		}
		case 5:{
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
		
		}while(option!=5);
	}
}
