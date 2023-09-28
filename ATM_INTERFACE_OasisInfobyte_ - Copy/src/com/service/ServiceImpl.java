package com.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.model.Account;

public class ServiceImpl implements Services {

	Scanner sc = new Scanner(System.in);
	Account a = new Account();

	@Override
	public void createAccountUserIdAndPass() {
		System.out.println("-------------:: CREATE CREDENTIALS ::--------------\n");
		System.out.print(" Create UserId : ");
		a.setUserId(sc.next());
		System.out.print(" Create Password : ");
		a.setUserPin(sc.next());
	}

	@Override
	public void openAccount() {
		System.out.println("-------------:: OPEN YOUR ACCOUNT ::--------------\n");
		System.out.println("Welcome to the ATM!");
		System.out.println("------Enter Credentials :------ ");
		System.out.print("Enter User ID: ");
		String userIdInput = sc.next();
		System.out.print("Enter PIN: ");
		String pinInput = sc.next();

		if (a.getUserId().equals(userIdInput) && a.getUserPin().equals(pinInput)) {
			System.out.println("Your Account Open Successfully !!!");

			System.out.print("Your Account Balence is : ");
			a.setBalance(sc.nextDouble());

			System.out.print("Account Holder  Name : ");
			sc.nextLine();
			a.setAccHolderName(sc.nextLine());

			System.out.print("Account Holder Address : ");
			a.setAccHolderAddr(sc.nextLine());

			System.out.print("Account Holder Aadhar : ");
			a.setAccHolderAadhar(sc.nextLong());

			System.out.print("Account Holder Mobile No. : ");
			a.setAccHolderMob(sc.nextLong());

		} else {
			System.out.println("Invalid User ID or PIN. Exiting...");
		}
		System.out.println("Welcome, " + a.getUserId() + "!");
	}

	@Override
	public void getAccountDetails() {
		System.out.println("-------------:: ACCOUNT DETAILS ::--------------\n");
		System.out.println("------Enter Credentials :------ ");
		System.out.print("Enter User ID: ");
		String userIdInput = sc.next();
		System.out.print("Enter PIN: ");
		String pinInput = sc.next();
		if (a.getUserId().equals(userIdInput) && a.getUserPin().equals(pinInput)) {
			System.out.println("Your Account Open Successfully !!!\n");
			System.out.println("Your Account Balence is : " + a.getBalance());
			System.out.println("Account Holder  Name : " + a.getAccHolderName());
			System.out.println("Account Holder Address : " + a.getAccHolderAddr());
			System.out.println("Account Holder Aadhar : " + a.getAccHolderAadhar());
			System.out.println("Account Holder Mobile No. : " + a.getAccHolderMob());
		} else {
			System.out.println("Invalid User ID or PIN. Exiting...");
		}
	}

	@Override
	public void deposit() {
		System.out.println("-------------:: DEPOSIT ::--------------\n");
		System.out.print("Enter deposit amount: $");
		double depositAmount = sc.nextDouble();
		a.deposit(depositAmount);
	}

	@Override
	public void withdraw() {
		System.out.println("-------------:: WITHDRAW ::--------------\n");
		System.out.print("Enter withdrawal amount: $");
		double withdrawAmount = sc.nextDouble();
		a.withdraw(withdrawAmount);
	}

	@Override
	public void transfer() {
		System.out.println("-------------:: TRANSFER ::--------------\n");
		System.out.print("Enter recipient's User ID: ");
		String recipientUserId = sc.next();
		sc.nextLine(); // Consume newline
		Account recipientAccount = new Account();
		recipientAccount.setUserId(recipientUserId);
		System.out.print("Enter transfer amount: $");
		double transferAmount = sc.nextDouble();

		double balance = a.getBalance();
		if (transferAmount > 0 && transferAmount <= balance) {
			balance = balance - transferAmount;
			recipientAccount.transferAmmount(transferAmount);
			a.getTransactionHistory().add("Transfer to " + recipientAccount.getUserId() + ": $ " + transferAmount);
		} else {
			System.out.println("Insufficient funds or invalid Transfer amount.");
		}
	}

	@Override
	public void transactionHistory() {
		System.out.println("-------------:: TRANSACTION HISTORY ::--------------\n");
		ArrayList<String> history = a.getTransactionHistory();
		System.out.println("\nTransaction History:");
		if (history.isEmpty()) {
			System.out.println("No transactions have been recorded.");
		} else {
			for (String transaction : history) {
				System.out.println(transaction);
			}
		}
	}
}