package com.abccompany.carrentalsystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.abccompany.carrentalsystem.dataaccess.Dao;
import com.abccompany.carrentalsystem.dataaccess.DataAccessFactory;
import com.abccompany.carrentalsystem.model.Payment;
import com.abccompany.carrentalsystem.model.Reservation;

public class ReservationDao implements Dao {

	private String insertQuery;
	@Override
	public String getSql() {
		// TODO Auto-generated method stub
		return "select * from Reservation";
	}

	@Override
	public void unpackResultSet(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> getResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSqlOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSqlInsert() {
		// TODO Auto-generated method stub
		return getInsertQuery();
	}

	public String getInsertQuery() {
		return insertQuery;
	}

	public void setInsertQuery(String insertQuery) {
		this.insertQuery = insertQuery;
	}

	@Override
	public String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void addNewReservation(Reservation reserv, Payment payment, boolean isLoggedIn) throws SQLException{
	
		
		 PreparedStatement ps = DataAccessFactory.getDataAccessConnection()
			        .prepareStatement("insert into reservation values (?,?,?,?)");
		 ps.setInt(1, reserv.getConfirmationNumber());
		 ps.setDate(2, reserv.getPickupDate());
		 ps.setDate(3, reserv.getDropoffDate());
		 ps.setInt(4, reserv.getVehicle().getPlate().intValue());
		 
		 ps.executeUpdate();
		 
		 if(isLoggedIn){
			 //check for discount
			 //add payment
		 } else{
			 //just add payment, there is no discount
			 //they will logged in with the id
		 }
		 
		 //process payment here
		 
		
		//add to transaction, remove this part
		
	}

	@Override
	public String getSqlSubElements() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
