package com.abccompany.carrentalsystem.dataaccess;

import java.sql.Connection;
import java.sql.SQLException;

import com.abccompany.carrentalsystem.dataaccess.DataAccessSubSystem.ConnectManager;

public class DataAccessFactory {
	public static DataAccess getDataAccess() {
		return new DataAccessSubSystem();
	}

	public static Connection getDataAccessConnection() throws SQLException {
		DataAccessSubSystem.ConnectManager a = new ConnectManager();
		return a.getConnection();
	}

}
