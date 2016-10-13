package com.abccompany.carrentalsystem.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abccompany.carrentalsystem.dataaccess.Dao;
import com.abccompany.carrentalsystem.dataaccess.DataAccessFactory;
import com.abccompany.carrentalsystem.model.Vehicle;

public class VehicleDao implements Dao {

	private int plate;
	private String insertQuery;
	private String deleteQuery;
	private List<Vehicle>listOfVehicles;
	//get all vehicles
	@Override
	public String getSql() {
		return "SELECT * FROM Vehicle";
	}

	@Override
	public void unpackResultSet(ResultSet rs) throws SQLException {
		listOfVehicles = new ArrayList<Vehicle>();
		while(rs.next()){
			int plateNumber = Integer.parseInt(rs.getString(1));
			int numberOfSeats  = Integer.parseInt(rs.getString(2));
			String carType = rs.getString(3);
			double dailyPrice = Double.parseDouble(rs.getString(4));
			String make = rs.getString(5);
			int manufacturYear = Integer.parseInt(rs.getString(6));
			byte[] photo = rs.getString(7).getBytes();
			
			//add to the list of vehicles
			
			listOfVehicles.add(new Vehicle(plateNumber, numberOfSeats, carType, dailyPrice, make,
					manufacturYear));
		}
		
	}

	@Override
	public List<?> getResults() {
		return listOfVehicles;
	}

	@Override
	public String getSqlOne() {
		// TODO Auto-generated method stub
		return "select * from vehicle where plate = "+ getPlate();
	}

	public int getPlate() {
		return plate;
	}

	public void setPlate(int plate) {
		this.plate = plate;
	}

	
	public String getInsertQuery() {
		return insertQuery;
	}

	public void setInsertQuery(String insertQuery) {
		this.insertQuery = insertQuery;
	}

	@Override
	public String getSqlInsert() {
		return getInsertQuery();
	}
	
	public void addNewVehicle(int plate2, int numberOfSeats, String type, double price, String brand, int year, File file) throws FileNotFoundException, SQLException{
		FileInputStream fis = new FileInputStream(file);
		 PreparedStatement ps = DataAccessFactory.getDataAccessConnection()
			        .prepareStatement("insert into vehicle values (?,?,?,?,?,?,?)");
		 ps.setInt(1, plate2);
		 ps.setInt(2, numberOfSeats);
		 ps.setString(3, type);
		 ps.setDouble(4, price);
		 ps.setString(5, brand);
		 ps.setInt(6, year);
		 ps.setBinaryStream(7, fis);
		 ps.setInt(8, 0); //unreserved car
		 ps.executeUpdate();	 
	}
	public void updateVehicleInfo(int plate2, int numberOfSeats, String type, double price, String brand, int year, File file) throws FileNotFoundException, SQLException{
		FileInputStream fis = new FileInputStream(file);
		 PreparedStatement ps = DataAccessFactory.getDataAccessConnection()
			        .prepareStatement("update vehicle set plate =?,numberOfSeats =?, carType =?, dailyPrice =?,"
			        		+ "make =?, manufacturedYear = ?, photo = ? where plate = ? ");
		 ps.setInt(1, plate2);
		 ps.setInt(2, numberOfSeats);
		 ps.setString(3, type);
		 ps.setDouble(4, price);
		 ps.setString(5, brand);
		 ps.setInt(6, year);
		 ps.setBinaryStream(7, fis);
		 ps.setInt(8, plate2);
		 
		 ps.executeUpdate();
		 
		ps.close(); 
	}
	
	public void deleteVehicle(int plateNumber) throws SQLException{
		PreparedStatement ps = DataAccessFactory.getDataAccessConnection().prepareStatement("delete from vehicle where plate =  "+ plateNumber);
		ps.executeUpdate();
	}
	
	public void notRentedVehiclesList(){
		
	}

	public String getDeleteQuery() {
		return "delete vehicle where plate = " + plate;
	}

	@Override
	public String getSqlSubElements() {
		// TODO Auto-generated method stub
		return "select * from vehicle where status = 0";
	}

}
