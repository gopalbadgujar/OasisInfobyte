package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Cancellation;
import com.model.Login;
import com.model.Reservation;
import com.mysql.jdbc.log.Log;
import com.util.HibernateUtil;

public class ServiceImpl implements Services {

	SessionFactory sf = HibernateUtil.geSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void createLogin() {
		System.out.println("------ LOGIN CREDENTIALS ------");
		Session session = sf.openSession();

		Login l = new Login();
		System.out.println("Create Username : ");
		l.setCorrectUsername(sc.next());
		System.out.println("Create Password : ");
		l.setCorrectPassword(sc.next());

		int i =(int) session.save(l);
		session.beginTransaction().commit();
		System.out.println("Login id : "+i);
	}

	@Override
	public void login() {
		System.out.println("------ LOGIN FORM ------\n");
		Session session = sf.openSession();

		System.out.println(":: WELCOME TO ONLINE RESERVATION SYSTEM ::");
		System.out.print("Enter login id : ");
		Login l = session.get(Login.class, sc.nextInt());
		if (l != null) {
			System.out.print("Enter Username : ");
			String username = sc.next();
			System.out.print("Enter Password : ");
			String password = sc.next();

			if (username.equals(l.getCorrectUsername()) && password.equals(l.getCorrectPassword())) {
				System.out.println("Login successful! You can now access the system.");
				// Add your main system logic here
			} else {
				System.out.println("Login failed. Incorrect username or password. \n");
			}
		} else {
			System.out.println("Login id Not found , Try Again...");
		}
		session.save(l);
		session.beginTransaction().commit();
	}

	@Override
	public void reservation() {
		System.out.println("------ RESERVATION SYSTEM ------\n");
		Session session = sf.openSession();

		System.out.println(":: WELCOME TO RESERVATION SYSTEM ::");
		Reservation reserv = new Reservation();
		System.out.print("Enter login id : ");
		Login l = session.get(Login.class, sc.nextInt());
		if (l != null) {
			System.out.print("Enter Your Name : ");
			sc.nextLine();
			reserv.setUsername(sc.nextLine());
			System.out.print("Enter PNR Number : ");
			reserv.setPnr(sc.next());
			System.out.print("Enter Train Number : ");
			reserv.setTrainNo(sc.next());
			System.out.print("Enter Class Type : ");
			reserv.setClassType(sc.next());
			System.out.print("Enter Date Of Journey(yy-mm-dd) : ");
			reserv.setDateOfJourney(sc.next());
			System.out.print("Enter Departure Place : ");
			reserv.setDeparture(sc.next());
			System.out.print("Enter Destination Place : ");
			reserv.setDestination(sc.next());
			reserv.setLogin(l);
			session.save(reserv);
			session.beginTransaction().commit();
		} else {
			System.out.println("Login id Not found , Try Again...");
		}
	}

	@Override
	public void cancellation() {
		System.out.println("------ CANCELLATION SYSTEM ------");
		Session session = sf.openSession();

		System.out.println(":: WELCOME TO CANCELLATION SYSTEM ::");
		Cancellation c = new Cancellation();
		System.out.println("Enter Reservation Id : ");
		Reservation r = session.get(Reservation.class, sc.nextInt());
		if (r != null) {
			System.out.println("User Name : " + r.getUsername());
			System.out.println("PNR Number : " + r.getPnr());
			System.out.println("Train Number : " + r.getTrainNo());
			System.out.println("Class Type : " + r.getClassType());
			System.out.println("Date_Of_Journey : " + r.getDateOfJourney());
			System.out.println("Departure Place : " + r.getDeparture());
			System.out.println("Destination Place : " + r.getDestination());
			c.setReservation(r);
			c.getReservation();

			System.out.println("Do you want to cancel this reservation? (yes/no): ");
			String choice = sc.next().toLowerCase();

			if (choice.equals("yes")) {
				session.saveOrUpdate(c);
				session.delete(c);
				session.beginTransaction().commit();
				System.out.println("Reservation cancelled successfully.");
			} else {
				System.out.println("Reservation not cancelled.");
			}
		} else {
			System.out.println("Reservation id Not found , Try Again...");
		}

	}

}
