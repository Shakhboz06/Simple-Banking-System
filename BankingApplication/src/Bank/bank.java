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
}
