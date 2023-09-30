package com.controller;

import com.model.MCQ;
import com.service.ServiceImpl;

import java.util.Scanner;

public class OnlineExaminationSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ServiceImpl s = new ServiceImpl();

		boolean flag = true;
		while (flag) {

			System.out.println("---------------------------------------------------------------------");
			System.out.println("--------------------::ONLINE EXAMINATION SYSTEM::--------------------");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("                   1. Create User :                                  ");
			System.out.println("                   2. Login :                                        ");
			System.out.println("                   3. Update Profile and Password :                  ");
			System.out.println("                   4. Show Details :                                 ");
			System.out.println("                   5. Start Exam :                                   ");
			System.out.println("                   6. CLOSE EXAM :                                   ");
			System.out.println("                   7. Exit :                                         ");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("---------------------------------------------------------------------");

			System.out.println("Choose Your Option : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				s.createUser();
				break;
			case 2:
				s.loginUser();
				break;
			case 3:
				s.updateProfileAndPassword();
				break;
			case 4:
				s.showDetails();
				break;
			case 5:
				s.startExam();
				break;
			case 6:
				s.ClosingSessionAndLogout();
				break;
			case 7:
				System.out.println(" EXITING THE APPLICATION !!!");
				flag = false;
				break;
			default:
				break;
			}

		}
	}
}