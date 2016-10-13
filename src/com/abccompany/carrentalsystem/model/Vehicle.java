package com.abccompany.carrentalsystem.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vehicle {
	private static final long serialVersionUID = 100010L;

	private IntegerProperty plate;

	private IntegerProperty numberOfSeats;

	private String carType;

	private DoubleProperty dailyPrice;

	private StringProperty make;

	private IntegerProperty manufacturedYear;

	public Vehicle(String carType) {
		this.carType = carType;
	}

	public Vehicle(Integer plate, int numberOfSeats, String carType,
			double dailyPrice, String make, int manufacturedYear) {
		this.plate = new SimpleIntegerProperty(plate);
		this.numberOfSeats = new SimpleIntegerProperty(numberOfSeats);
		this.carType = carType;
		this.dailyPrice = new SimpleDoubleProperty(dailyPrice);
		this.make = new SimpleStringProperty(make);
		this.manufacturedYear = new SimpleIntegerProperty(manufacturedYear);
	}

	public DoubleProperty getDailyPrice() {
		return dailyPrice;
	}

	public StringProperty getMake() {
		return make;
	}

	public IntegerProperty getManufacturedYear() {
		return manufacturedYear;
	}

	public IntegerProperty getPlate() {
		return plate;
	}

	public IntegerProperty getNumberOfSeats() {
		return numberOfSeats;
	}

	
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Vehicle)) {
			return false;
		}
		Vehicle other = (Vehicle) object;
		return plate == other.plate;
	}

	@Override
	public String toString() {
		return "Vehicle [plate=" + plate + ", numberOfSeats=" + numberOfSeats
				+ ", carType=" + carType + ", dailyPrice=" + dailyPrice
				+ ", make=" + make + ", transmission=" + ", manufacturedYear="
				+ manufacturedYear + "]";
	}

	//mapping to jfx columns
	public StringProperty plateProperty() {
		return new SimpleStringProperty(carType);
	}
	public StringProperty numberOfSeatsProperty() {
		return new SimpleStringProperty(carType);
	}
	public StringProperty carTypeProperty() {
		return new SimpleStringProperty(carType);
	}
	public DoubleProperty dailyPriceProperty() {
		return dailyPrice;
	}
	public StringProperty makeProperty(){
		return make;
	}
	public IntegerProperty manufacturedYearProperty(){
		return manufacturedYear;
	}
	

}
