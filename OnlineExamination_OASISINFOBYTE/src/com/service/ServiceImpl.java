package com.service;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.model.MCQ;
import com.model.User;

public class ServiceImpl implements Services {
	private static Timer timer;
	private static int remainingTime;

	static Scanner sc = new Scanner(System.in);
	User u = new User();

	// Create some sample MCQ questions
	static MCQ[] questions = { new MCQ("What is 2 + 2?", new String[] { "1", "2", "3", "4" }, 3),
			new MCQ("What is the capital of France?", new String[] { "London", "Berlin", "Madrid", "Paris" }, 3), };

	@Override
	public void createUser() {
		System.out.println("---------------::CREATE CREDENTIALS::---------------");
		System.out.print(" Create UserName : ");
		u.setUsername(sc.next());
		System.out.print(" Create Password : ");
		u.setPassword(sc.next());
	}

	@Override
	public void loginUser() {
		System.out.println("---------------::LOGIN::---------------");

		System.out.println("Welcome to the Online Examination !");

		System.out.print("Enter username:");
		String username = sc.next();
		System.out.print("Enter password:");
		String password = sc.next();
		if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
			System.out.println("Login successful!");
			System.out.print("Enter your Name: ");
			sc.nextLine();
			u.setName(sc.nextLine());
			System.out.print("Enter your E-mail: ");
			u.setEmail(sc.next());
			System.out.print("Enter Your Mobile Number : ");
			u.setMobNo(sc.nextLong());
		} else {
			System.out.println("Login failed. Exiting...");
		}
	}

	@Override
	public void updateProfileAndPassword() {
		System.out.println("---------------::UPDATE PROFILE AND PASSWORD::---------------");

		System.out.print("Enter username:");
		String username = sc.next();
		System.out.print("Enter password:");
		String password = sc.next();
		if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
			System.out.println("Login successful!");
			boolean flag = true;
			while (flag) {
				System.out.println("UPDATE PROFILE");
				System.out.println("1. Update UserName : ");
				System.out.println("2. Update Password : ");
				System.out.println("3. Update Name : ");
				System.out.println("4. Enter Email : ");
				System.out.println("5. Enter Mobile Number : ");
				System.out.println("6. Return to Main Menu : ");
				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();
				sc.nextLine(); // Consume the newline character

				switch (choice) {
				case 1:
					System.out.print("Enter your new Username: ");
					u.setUsername(sc.next());
					System.out.println("Name updated successfully.");
					break;
				case 2:
					System.out.print("Enter your new Password : ");
					u.setPassword(sc.next());
					System.out.println("Pasword updated successfully.");
					break;
				case 3:
					System.out.print("Enter your new Name: ");
					u.setName(sc.nextLine());
					System.out.println("Name updated successfully.");
					break;
				case 4:
					System.out.print("Enter your new email: ");
					u.setEmail(sc.next());
					System.out.println("Email updated successfully.");
					break;
				case 5:
					System.out.print("Enter Your New Mobile Number : ");
					u.setMobNo(sc.nextLong());
					System.out.println("Mobile Number updated successfully.");
					break;
				case 6:
					System.out.println("Return to main Menu..");
					flag = false;
					break;
				default:
					System.out.println("Invalid choice. Try Again...");
					break;
				}
			}
		} else {
			System.out.println("Login failed. Exiting...");
		}

	}

	@Override
	public void showDetails() {
		System.out.println("---------------::SHOW USER DETAILS::---------------");
		System.out.print("Enter username:");
		String username = sc.next();
		System.out.print("Enter password:");
		String password = sc.next();
		if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
			System.out.println("Login successful!");
			System.out.println("Name Of User : " + u.getName());
			System.out.println("Email of User : " + u.getEmail());
			System.out.println("Mobile Numer of User : " + u.getMobNo());
		} else {
			System.out.println("Login failed. Exiting...");
		}
	}

	@Override
	public void startExam() {
		System.out.println("---------------::START EXAM::---------------");
		System.out.print("Enter username:");
		String username = sc.next();
		System.out.print("Enter password:");
		String password = sc.next();
		if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
			System.out.println("Login successful!");
			timerAndAutoSubmit();
			submitAnswers();

		} else {
			System.out.println("Login failed. Exiting...");
		}
	}

	private void timerAndAutoSubmit() {
		// Timer And Auto Submit
		int examDuration = 10;
		timer = new Timer();
		remainingTime = examDuration;
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("Time's up! Submitting your answers...");
				ClosingSessionAndLogout();
			}
		}, examDuration * 1000);
	}

	private void submitAnswers() {
		System.out.println("---------------::SUBMITTING ANSWERS::---------------");
		int score = 0; // Initialize the score

		// Loop through each MCQ question to compare the user's answers with the correct
		// answers
		for (int i = 0; i < questions.length; i++) {
			MCQ question = questions[i];

			// Display the question
			System.out.println("Question " + (i + 1) + ": " + question.getQuestion());

			// Display answer choices
			String[] options = question.getOptions();
			for (int j = 0; j < options.length; j++) {
				System.out.println((char) ('A' + j) + ". " + options[j]);
			}

			// Prompt the user for an answer
			// Selecting Answers For MCQs.
			System.out.print("Enter your answer for Question " + (i + 1) + " (A/B/C/D): \n");
			String userAnswer = sc.next().toUpperCase();

			// Check if the answer is correct
			int correctOptionIndex = question.getCorrectOption();
			char correctAnswer = (char) ('A' + correctOptionIndex);

			if (userAnswer.equals(String.valueOf(correctAnswer))) {
				System.out.println("Your answer for Question " + (i + 1) + " is correct!");
				score++;
			} else {
				System.out.println("Your answer for Question " + (i + 1) + " is incorrect.");
				System.out.println("The correct answer is " + correctAnswer);
			}

			System.out.println(); // Add a newline for spacing
		}

		// Display the final score
		System.out.println("Your score: " + score + "/" + questions.length);
	}

	@Override
	public void ClosingSessionAndLogout() {
		System.out.println("---------------::CLOSE EXAM::---------------");
		timer.cancel();
		System.out.println("Exam submitted. Thank you for taking the exam!");
		System.exit(0);
	}
}
