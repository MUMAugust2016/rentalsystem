package com.abccompany.carrentalsystem.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.abccompany.carrentalsystem.dataaccess.Dao;

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
	
	

}
