package App;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bank.bank bank = new Bank.bank(); 
		Scanner scanner = new Scanner(System.in);
		Accounts.Accounts acc = new Accounts.Accounts("789", "Shahboz Shodiev");
		System.out.println(acc.getAccountHolder());
		System.out.println(acc.getAccountNumber());
//		acc.Deposit(5000);
//		acc.Withdraw(350);
//		acc.Transactions();
		bank.AddAccount("789", "Jacob Blake");
		System.out.print(bank.getAccount("789"));
		
			
//		while(true) {
//			System.out.println("\nWelcome to Simple Banking System!");
//            System.out.println("1. Create a new account");
//            System.out.println("2. Deposit money");
//            System.out.println("3. Withdraw money");
//            System.out.println("4. View account balance");
//            System.out.println("5. View transactions");
//            System.out.println("6. Exit");
//            System.out.print("Please select an option: ");
//            
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            
//            
//            switch(choice) {
//            	
//            	case 1:
//            		System.out.print("Enter account number: ");
//                    String accountNumber = scanner.nextLine();
//                    System.out.print("Enter account holder name: ");
//                    String accountHolder = scanner.nextLine();
//                    bank.AddAccount(accountNumber, accountHolder);
//                    break;
//                    
//            	case 2:
//            		System.out.print("Enter account number: ");
//                    accountNumber = scanner.nextLine();
//                    Accounts.Accounts account = bank.getAccounts(accountNumber);
//                    if (account != null) {
//                        System.out.print("Enter amount to deposit: ");
//                        double amount = scanner.nextDouble();
//                        account.Deposit(amount);
//                    } else {
//                        System.out.println("Account not found.");
//                    }
//                    break;
//                    
//            	case 3:
//                    System.out.print("Enter account number: ");
//                    accountNumber = scanner.nextLine();
//                    account = bank.getAccounts(accountNumber);
//                    if (account != null) {
//                        System.out.print("Enter amount to withdraw: ");
//                        double amount = scanner.nextDouble();
//                        account.Withdraw(amount);
//                    } else {
//                        System.out.println("Account not found.");
//                    }
//                    break;
//                case 4:
//                    System.out.print("Enter account number: ");
//                    accountNumber = scanner.nextLine();
//                    account = bank.getAccounts(accountNumber);
//                    if (account != null) {
//                        System.out.println("Current balance: " + account.getBalance());
//                    } else {
//                        System.out.println("Account not found.");
//                    }
//                    break;
//                case 5:
//                    System.out.print("Enter account number: ");
//                    accountNumber = scanner.nextLine();
//                    account = bank.getAccounts(accountNumber);
//                    if (account != null) {
//                        account.Transactions();
//                    } else {
//                        System.out.println("Account not found.");
//                    }
//                    break;
//                case 6:
//                    System.out.println("Exiting...");
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");	
//            		
//            }
//		}	
	}
}
