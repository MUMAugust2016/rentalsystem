package com.abccompany.carrentalsystem.dataaccess;

public class DataAccessFactory {
	public static DataAccess getDataAccess(){
		return new DataAccessSubSystem();
	}

}
