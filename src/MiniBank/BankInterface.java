package MiniBank;

import java.util.Scanner;

public class BankInterface {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankingSystem bankingSystem = null;
		int option;
		
		System.out.println("GO AHEAD\n1.Create Account\n2.Login\n3.Exit");
		option = scanner.nextInt();
		do {
		switch(option) {
		case 1: {
			System.out.println("Create your Account");
			System.out.println("Enter your name: ");
			String name=scanner.next();
			
			long acNo = AccountNumberGenerator.generateAcNo();		
			System.out.println("Set Pin");
			int pin=scanner.nextInt();
			System.out.println("Deposit Initial Amount");
			int depAmount = scanner.nextInt();
			 bankingSystem= new BankingSystem(name, acNo , pin , depAmount);
			 AccountDBService.saveBankAccount(bankingSystem);
			 System.out.println("Your Account num: "+acNo);
			 
			break;
		}
		case 2:{
			System.out.println("Login:");
			System.out.print("Enter account Number: ");
			long acNo = scanner.nextLong();		
			System.out.println();
			System.out.println("Enter Pin");
			int pin=scanner.nextInt();
			
			if(pin<1000||acNo<1000000000L) {
				System.out.println("Enter valid Credintials"); 
			}else {
			BankingSystem loggedInUserBankingSystem= AccountDBService.login(acNo, pin);
			if(loggedInUserBankingSystem!=null) {
				System.out.println("Login Successful");
				loggedInUserBankingSystem.loggedIn();
				return;
			}
			else {
				System.out.println("Invalid Accoount number or pin");
				break;
			}
			}
			break;
		}
		case 3:
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}}while(option!=3);
		scanner.close();
	}
	
}
