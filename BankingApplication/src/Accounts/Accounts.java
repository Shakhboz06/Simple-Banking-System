package Accounts;

import java.util.ArrayList;

public class Accounts {
	
	private String accountNumber;
	private String accountHolder;
	private double balance;
	private ArrayList<String> transactions;

	public Accounts(String accountNumber, String accountHolder) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = 0.0;
		this.transactions = new ArrayList<String>();
	}
	
	public void Deposit(double amount) {
		if( amount > 0) {
			transactions.add("Deposited: " + amount);
			balance += amount;
            System.out.println("Amount deposited successfully. Current Balance: " + balance);
		}else {
			System.out.println("Invalid amount");
		}
	}
	
	public void Withdraw (double amount) {
		
		if(amount > 0 && balance >= amount) {
			transactions.add("Withdrawn: " + amount);
			balance -= amount;
            System.out.println("Amount withdrawn successfully. Current Balance: " + balance);
		}else {
			System.out.println("You do not have sufficient amount in your balance");
		}
	}
	
	public void Transactions () {
		
		for(String item: transactions) {
			System.out.println(item);
		}
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}

