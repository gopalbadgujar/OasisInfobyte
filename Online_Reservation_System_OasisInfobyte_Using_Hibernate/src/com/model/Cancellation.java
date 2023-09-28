package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cancellation {

	@Id
	private int cid;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Reservation reservation;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Cancellation [cid=" + cid + ", reservation=" + reservation + "]";
	}
	
	
	 
}
