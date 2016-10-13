package com.abccompany.carrentalsystem.model;

import java.sql.Date;
import java.time.LocalDate;

public class Reservation {

	private static final long serialVersionUID = 100008L;
	
	private static Integer confirmationNumber = 100000;

	private Date pickupDate;

	private Date dropoffDate;

	private Vehicle vehicle;


	public Reservation() {
	}

	public Reservation(Integer confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public Reservation(Integer confirmationNumber, Date pickupDate,
			Date dropoffDate) {
		confirmationNumber ++;

		this.pickupDate = pickupDate;
		this.dropoffDate = dropoffDate;
	}

	public Integer getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(Integer confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getDropoffDate() {
		return dropoffDate;
	}

	public void setDropoffDate(Date dropoffDate) {
		this.dropoffDate = dropoffDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (confirmationNumber != null ? confirmationNumber.hashCode() : 0);
		return hash;
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Reservation)) {
			return false;
		}
		Reservation other = (Reservation) object;
		if ((this.confirmationNumber == null && other.confirmationNumber != null)
				|| (this.confirmationNumber != null && !this.confirmationNumber
						.equals(other.confirmationNumber))) {
			return false;
		}
		return true;
	}

	// @Override
	// public String toString() {
	// return "Reservation[ confirmationNumber=" + confirmationNumber + " ]";
	// }

}
