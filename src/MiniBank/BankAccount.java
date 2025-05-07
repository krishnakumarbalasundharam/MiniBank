package MiniBank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public abstract class BankAccount {


public BankAccount(String ownerNm, long acNo, int pinNo, double initialBalance) {
	// TODO Auto-generated constructor stub
	this.accountNumber=acNo;
	this.balance=initialBalance;
	this.ownerName=ownerNm;
	this.pin = pinNo;
}


public void loggedIn() {
	int option;
	boolean isLoggedIn = true;
	while(isLoggedIn) {
		System.out.println("Hi "+getOwnerName());
		System.out.println("Select a Service: \n1.Deposit\n2.Withdraw"
				+ "\n3.View details\n4.Exit");
		Scanner scanner=new Scanner(System.in);
		option= scanner.nextInt();
		scanner.nextLine();
		switch (option) {
		
		case 1:{
			System.out.println("Enter Amount to Deposit");
			Double dep=scanner.nextDouble();
			deposit(dep);
			break;
		}
		case 2:{
			System.out.println("Enter Amount to withdraw");
			Double with=scanner.nextDouble();
			withdraw(with);
			break;
		}
		case 3:{
			getDetails();
			break;
		}
		case 4:{
			isLoggedIn=false;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
		
		}
	
}

private String ownerName;
private long accountNumber;
private double balance;
private int pin;

//getters and setters field
public String getOwnerName() {
	return ownerName;
}
public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}

public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}

public void setBalance(int amount) {
	this.balance=amount;
}

public long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
}
//methods
public void deposit(double amount) {
	if(amount <0) {
		System.out.println("Enter a positive value");
	}
	else {
		balance+=amount;
		System.out.println("Deposited amount: "+amount);
		
	}
}
public void withdraw(double amount) {
	if(amount<0) {
		System.out.println("Enter a positive value");
	}
	else if(amount>balance) {
		System.out.println("Insufficient Balance\nAvailable Balance: "+balance);
	}
	else {
		balance-=amount;
		System.out.println("Amount Withdrawn: "+amount);
		System.out.println("remaining Balance: "+ balance);
	}
}
public double getBalance() {
	return balance;
}
public void getDetails() {
	System.out.println("Account Holder: "+ getOwnerName());
	System.out.println("Account Number: "+ getAccountNumber());
	System.out.println("Balance Available: "+ getBalance());
}



}
