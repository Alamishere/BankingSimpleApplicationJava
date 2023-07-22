package com.alam.project.BankingApplication;
import java.util.Scanner;


public class BankAccount {
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	public BankAccount(String customerName, String customerId) {
		this.customerName = customerName;
		this.customerId = customerId;
	}

	void deposit(int amount) {
		if(amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}
	
	void showPreviousTransaction() {
		if(previousTransaction > 0)
			System.out.println("Deposited: " + previousTransaction);
		else if(previousTransaction < 0)
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		else
			System.out.println("No Transaction Occurred");
	}
	
	void showMenu() {
		char option;
		Scanner scanner = new Scanner(System.in);
		String menu = "Welcome to Alam Banking " + customerName +
					  "\nYour ID is " + customerId +
					  "\nA. Check Balance" +
					  "\nB. Deposit" +
					  "\nC. Withdraw" +
					  "\nD. Previous Transaction" +
					  "\nE. Exit";

		do {
			System.out.println(menu);
			option = scanner.next().charAt(0);
			System.out.println();
			
			switch (option) {
				case 'A':
					System.out.println("Balance= " + balance);
					break;
						
				case 'B':
					System.out.println("Enter an amount to deposit: ");
					deposit(scanner.nextInt());
					break;
					
				case 'C':
					System.out.println("Enter an amount to withdraw: ");
					withdraw(scanner.nextInt());
					break;
	
				case 'D':
					showPreviousTransaction();			
					break;
			
				case 'E':
					break;
			
				default:
					System.out.println("Invalid option!! Please enter again");
			}

		} while (option != 'E');
		
		System.out.println("Thank you for using Alam's service");
	}
}

