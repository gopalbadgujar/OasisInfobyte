package com.model;

import java.util.ArrayList;

public class Account {

	private String userId;

	private String userPin;

	private double balance;

	private String accHolderName;

	private String accHolderAddr;

	private long accHolderAadhar;

	private long accHolderMob;

	private ArrayList<String> transactionHistory;

	public Account() {
		// Initialize transactionHistory as an empty ArrayList
		transactionHistory = new ArrayList<>();
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getAccHolderAddr() {
		return accHolderAddr;
	}

	public void setAccHolderAddr(String accHolderAddr) {
		this.accHolderAddr = accHolderAddr;
	}

	public long getAccHolderAadhar() {
		return accHolderAadhar;
	}

	public void setAccHolderAadhar(long accHolderAadhar) {
		this.accHolderAadhar = accHolderAadhar;
	}

	public long getAccHolderMob() {
		return accHolderMob;
	}

	public void setAccHolderMob(long accHolderMob) {
		this.accHolderMob = accHolderMob;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPin() {
		return userPin;
	}

	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<String> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(ArrayList<String> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	@Override
	public String toString() {
		return "Account [userId=" + userId + ", userPin=" + userPin + ", balance=" + balance + ", accHolderName="
				+ accHolderName + ", accHolderAddr=" + accHolderAddr + ", accHolderAadhar=" + accHolderAadhar
				+ ", accHolderMob=" + accHolderMob + ", transactionHistory=" + transactionHistory + "]";
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance = balance - amount;
			System.out.println("Withdrawal successful.");
			System.out.println("\t New balance: " + balance);
		} else {
			System.out.println("Insufficient funds or invalid withdrawal amount.");
		}
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance = balance + amount;
			System.out.println("Deposit successful.");
			System.out.println(" \t New balance: " + balance);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}
	
	public void transferAmmount(double amt) {
		if (amt > 0) {
			balance = balance + amt;
			System.out.println("Transfer successfully.");
			System.out.println(" \t Transfered balance: " + balance);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}
}
