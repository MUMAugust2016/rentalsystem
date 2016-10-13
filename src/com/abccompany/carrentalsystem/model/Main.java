package com.abccompany.carrentalsystem.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


import com.abccompany.carrentalsystem.dao.VehicleDao;
import com.abccompany.carrentalsystem.dataaccess.Dao;
import com.abccompany.carrentalsystem.dataaccess.DataAccess;
import com.abccompany.carrentalsystem.dataaccess.DataAccessFactory;

public class Main {
	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		Dao dao = new VehicleDao();
		DataAccess da = DataAccessFactory.getDataAccess();
//		da.delete(dao);
		
		
		
//			da.readAll(dao);
//			List<Vehicle> vehicles = (List<Vehicle>)dao.getResults();
//			//all cars
//			
//			for(Vehicle vehicle: vehicles){
//				System.out.println(vehicle);
//			}
		//here
			
			
//		System.out.println(System.getProperty("user.dir"));
		
			
			
			File file = new File("C:\\Users\\Admin\\workspace2\\rentalsystem\\src\\com\\abccompany\\carrentalsystem\\model\\car.jpg");
			
			
			System.out.println(file.exists());
			VehicleDao v = new VehicleDao();
			
			int plate = 1234;
			int numberOfSeats = 10;
			String type = "luxury";
			double price = 100;
			String brand = "toyota";
			int year = 2000;
			
			v.deleteVehicle(1234);
			//add new vehicle
//			v.addNewVehicle(plate, numberOfSeats, type, price, brand, year, file);
			//update query
//			v.updateVehicleInfo(1234, 9, "Lamburghini", price, brand, year, file);
			
			//assuming incoming values for them
//			String sql = "insert into vehicle values(" + 1234+ ","+10 + ","+ "\"luxury\"," + 100 + ","+ "\"Toyota\"," + 2000 + ","+ images.toString() +")";
//			System.out.println(sql);
//			dao.setInsertQuery(sql);
//			da.write(dao);
			
			
//		
	}
}
