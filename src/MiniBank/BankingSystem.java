package MiniBank;



public class BankingSystem {

public BankingSystem(String ownerNm, String acNo, double initialBalance) {
	// TODO Auto-generated constructor stub
	this.accountNumber=acNo;
	this.balance=initialBalance;
	this.ownerName=ownerNm;
}
private String ownerName;
private String accountNumber;
private double balance;

//getters and setters field
public String getOwnerName() {
	return ownerName;
}
public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}
public void setBalance(int amount) {
	this.balance=amount;
}

public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
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

public static void main(String[] args) {
	BankingSystem banking = new BankingSystem("Aravind", "87866643", 1000);
	banking.withdraw(300);
	banking.deposit(500);
	banking.getDetails();
	
	
}

}
