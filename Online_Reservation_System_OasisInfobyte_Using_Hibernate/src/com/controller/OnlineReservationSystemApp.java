package com.controller;

import java.util.Scanner;

import com.service.ServiceImpl;

public class OnlineReservationSystemApp {

	public static void main(String[] args) {
		boolean flag = true;
		ServiceImpl s = new ServiceImpl();
		Scanner sc = new Scanner(System.in);

		while (flag) {
			System.out.println("!!################################################!!");
			System.out.println("!!#----------------------------------------------#!!");
			System.out.println("!!#---------Online Reservation System------------#!!");
			System.out.println("!!#----------------------------------------------#!!");
			System.out.println("!!#       1. Create Login Credentials :          #!!");
			System.out.println("!!#       2. Login :                             #!!");
			System.out.println("!!#       3. Reservation :                       #!!");
			System.out.println("!!#       4. Cancellation :                      #!!");
			System.out.println("!!#       5. Exit :                              #!!");
			System.out.println("!!#----------------------------------------------#!!");
			System.out.println("!!#----------------------------------------------#!!");
			System.out.println("!!################################################!!\n");


			System.out.println("!!#----------------------------------------------#!!");
			System.out.println("!!#------------Enter your choice: ---------------#!!");
			System.out.println("!!#----------------------------------------------#!!");
			int choice = sc.nextInt();
			sc.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				s.createLogin();
				break;
			case 2:
				s.login();
				break;
			case 3:
				s.reservation();
				break;
			case 4:
				s.cancellation();
				break;
			case 5:
				System.out.println("Exiting the system. Goodbye!");
				flag = false;
				break;
			default:
				System.out.println("Invalid choice. Please try again...");
			}
		}
	}
}
