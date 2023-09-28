package com.controller;

import java.util.Scanner;
import com.service.ServiceImpl;

public class ATMInterfaceApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ServiceImpl s = new ServiceImpl();

		boolean flag = true;
		while (flag) {
			System.out.println("-|------------------------------------|-");
			System.out.println(" |************************************|");
			System.out.println(" |##                                ##|");
			System.out.println(" |!!         ATM Menu               !!|");
			System.out.println(" |!!##      **********            ##!!|");
			System.out.println(" |!!    1. CREATE CREDENTIALS   :   !!|");
			System.out.println(" |!!    2. OPEN ACCOUNT         :   !!|");
			System.out.println(" |!!    3. SHOW ACCOUNT DETAILS :   !!|");
			System.out.println(" |!!    4. DEPOSIT              :   !!|");
			System.out.println(" |!!    5. WITHDRAW             :   !!|");
			System.out.println(" |!!    6. TRANSFER             :   !!|");
			System.out.println(" |!!    7. TRANSACTION HISTORY  :   !!|");
			System.out.println(" |!!    8. QUIT                 :   !!|");
			System.out.println(" |##                                ##|");
			System.out.println(" |************************************|");
			System.out.println("-|------------------------------------|-\n");

			System.out.print("\nChoose an option:");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				s.createAccountUserIdAndPass();
				break;
			case 2:
				s.openAccount();
				break;
			case 3:
				s.getAccountDetails();
				break;
			case 4:
				s.deposit();
				break;
			case 5:
				s.withdraw();
				break;
			case 6:
				s.transfer();
				break;
			case 7:
				s.transactionHistory();
				break;
			case 8:
				System.out.println("----- THANK YOU FOR USING THE ATM. GOODBYE! -----");
				flag = false;
				break;
			default:
				System.out.println("Invalid choice. Please choose a valid option.");
			}
		}
	}
}
