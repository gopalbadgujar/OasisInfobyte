package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String correctUsername;
	
	private String correctPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorrectUsername() {
		return correctUsername;
	}

	public void setCorrectUsername(String correctUsername) {
		this.correctUsername = correctUsername;
	}

	public String getCorrectPassword() {
		return correctPassword;
	}

	public void setCorrectPassword(String correctPassword) {
		this.correctPassword = correctPassword;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", correctUsername=" + correctUsername + ", correctPassword=" + correctPassword
				+ "]";
	}

}
