package Bank;

import java.util.ArrayList;
import Accounts.Accounts;

public class bank {
	
	private ArrayList<Accounts> accounts;

	public bank() {
		super();
		this.accounts = new ArrayList<>();
	}
	
	public void AddAccount(String accountNumber, String accountHolder) {	
		Accounts newAccount = new Accounts(accountNumber, accountHolder);
		accounts.add(newAccount);
		System.out.println("New account created for " + accountHolder);
	}
	

	
	public Accounts getAccount(String accountNumber) {
		for(Accounts item: accounts) {
			if(item.getAccountNumber().equals(item.getAccountHolder())) {
				return item;
			}
		}
		
		return null;
	}
	
	public void listAllAccounts () {
		System.out.println("Listing all accounts");
		 for (Accounts account : accounts) {
		        System.out.println("Account Number: " + account.getAccountNumber() + ", Account Holder: " + account.getAccountHolder());
		   }
	}
	
	public void transferMoney(String fromAccNum, String toAccNum, double amount) {
		Accounts fromAccount = getAccount(fromAccNum);
	    Accounts toAccount = getAccount(toAccNum);
	    if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
	        fromAccount.Withdraw(amount);
	        toAccount.Deposit(amount);
	        System.out.println("Transfer successful: €" + amount + " from " + fromAccNum + " to " + toAccNum);
	    } else {
	        System.out.println("Transfer failed. Please check the accounts and balance.");
	    }
	    
	}
	
	public void updateAccountHolder(String accountNumber, String newHolderName) {
	    Accounts account = getAccount(accountNumber);
	    if (account != null) {
	        account.setAccountHolder(newHolderName);
	        System.out.println("Account holder name updated successfully.");
	    } else {
	        System.out.println("Account not found.");
	    }
	}
	
	public void deleteAccount(String accountNumber) {
	    Accounts account = getAccount(accountNumber);
	    if (account != null && account.getBalance() == 0) {
	        accounts.remove(account);
	        System.out.println("Account deleted successfully.");
	    } else {
	        System.out.println("Deletion failed. Account not found or balance not zero.");
	    }
	}
	
	public void calculateInterest(String accountNumber, double interestRate) {
	    Accounts account = getAccount(accountNumber);
	    if (account != null) {
	        double interest = account.getBalance() * (interestRate / 100);
	        account.Deposit(interest);
	        System.out.println("Interest of €" + interest + " added to the account.");
	    } else {
	        System.out.println("Account not found.");
	    }
	}
	
	public void searchAccountByName(String name) {
	    System.out.println("Search results:");
	    for (Accounts account : accounts) {
	        if (account.getAccountHolder().toLowerCase().contains(name.toLowerCase())) {
	            System.out.println("Account Number: " + account.getAccountNumber() + ", Account Holder: " + account.getAccountHolder());
	        }
	    }
	}
}
