package com.abccompany.carrentalsystem.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abccompany.carrentalsystem.loggger.RentalLogger;

public class DataAccessSubSystem implements DataAccess {

	public static class ConnectManager {

		private static final String DB_URL = "jdbc:mysql://localhost:3306/carrental?zeroDateTimeBehavior=convertToNull";
		private static final String USERNAME = "root";
		private static final String PASSWORD = "root";
		private static Connection conn = null;

		
		/**
		 * Illustrates an implementation of singliton design pattern
		 * 
		 * @return
		 * @throws SQLException
		 */
		public Connection getConnection() throws SQLException {
			if (conn == null) {
				conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
				System.out.println("Got successful");
			}
			return conn;
		}

	}

	@Override
	public void readAll(Dao dao) throws SQLException {
		// TODO Auto-generated method stub
		String query = dao.getSql();
		Connection con = null;
		try {
			con = (new ConnectManager()).getConnection();

			Statement stmt = con.createStatement();

			System.out.println("the query: " + query);
			ResultSet rs = stmt.executeQuery(query);
			dao.unpackResultSet(rs);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					// do nothing
				}
			}
		}

	}

	@Override
	public boolean write(Dao dao) throws SQLException {
		boolean isInserted = false;
		Connection con = null;
		try {
			con = (new ConnectManager()).getConnection();
			Statement stmt = con.createStatement();
			stmt.execute(dao.getSqlInsert());
			isInserted = true;
		} catch (Exception e) {
			// put logger here
			
		
			System.out.println("error happened");
			e.printStackTrace();
		}
		return isInserted;
	}

	@Override
	public ResultSet readOne(Dao dao) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = dao.getSqlOne();
		ResultSet rs;
		Connection con = null;
		try {
			con = (new ConnectManager()).getConnection();

			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(query);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					// do nothing
				}
			}
		}

		return rs;
	}

	@Override
	public boolean delete(Dao dao) throws SQLException {
		boolean isDeleted = false;
		String query = dao.getDeleteQuery();
		Connection con = null;
		try {
			con = (new ConnectManager()).getConnection();
			Statement stmt = con.createStatement();
			stmt.execute(query);
			isDeleted = true;
		} catch (Exception e) {
			System.out.println("deletion not completed");
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public void readPartOfRecord(Dao dao) throws SQLException {
		String query = dao.getSqlSubElements();
		Connection con = null;
		try {
			con = (new ConnectManager()).getConnection();

			Statement stmt = con.createStatement();

			System.out.println("the query: " + query);
			ResultSet rs = stmt.executeQuery(query);
			dao.unpackResultSet(rs);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					// do nothing
				}
			}
		}
		
	}
}
