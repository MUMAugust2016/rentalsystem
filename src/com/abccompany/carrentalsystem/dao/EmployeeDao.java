package com.abccompany.carrentalsystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abccompany.carrentalsystem.dataaccess.Dao;
import com.abccompany.carrentalsystem.model.Employee;

public class EmployeeDao implements  Dao {

	List<Employee> listOfEmployees;
	@Override
	public String getSqlInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSql() {
		// TODO Auto-generated method stub
		return "select * from employee";
	}

	@Override
	public void unpackResultSet(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
//		listOfEmployees = new ArrayList<Employee>();
//		//load address if there is any, not implemented here
//		while(rs.next()){
//			int plateNumber = Integer.parseInt(rs.getString(1));
//			int numberOfSeats  = Integer.parseInt(rs.getString(2));
//			String carType = rs.getString(3);
		
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
	public String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	@Override
	public String getSqlSubElements() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
