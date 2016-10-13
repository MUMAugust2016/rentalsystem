package view.reservation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.abccompany.carrentalsystem.dao.VehicleDao;
import com.abccompany.carrentalsystem.dataaccess.Dao;
import com.abccompany.carrentalsystem.dataaccess.DataAccess;
import com.abccompany.carrentalsystem.dataaccess.DataAccessFactory;
import com.abccompany.carrentalsystem.model.Vehicle;

public class reservationController extends Application implements Initializable {

	@FXML
	private DatePicker pickedupDate;

	@FXML
	private DatePicker dropDate;

	@FXML
	private Label dropDateLabel;

	@FXML
	private Label pickedupDateLabel;
	
	
	//add columns for vehicles
	@FXML
	private TableColumn<Vehicle, String> carType;
	@FXML
	private TableColumn<Vehicle, String> numberOfSeats;
	@FXML
	private TableColumn<Vehicle, String> dailyPrice;
	@FXML
	private TableColumn<Vehicle, String> make;
	@FXML
	private TableColumn<Vehicle, String> manufacturedYear;
	

	@FXML
	private TableView<Vehicle> imageView;

	private static ObservableList<Vehicle> vehicles;

	@FXML
	public void showReservationSummary() throws IOException {

		Main.showReservationSummaryScene();
	}

	private static int m = 100;
	
	static {
		

	}

	@FXML
	public void showCarsForSelection() throws IOException {


		Main.showSelectVehicleForReservation();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//        imageCol.prefWidthProperty().bind(imageView.widthProperty().subtract(292).divide(2));
		Dao vehicleDao = new VehicleDao();
		DataAccess dataAccess = DataAccessFactory.getDataAccess();
		try {
			dataAccess.readPartOfRecord(vehicleDao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		vehicles = FXCollections.observableArrayList((List<Vehicle>) vehicleDao.getResults());
        
			
		carType.setCellValueFactory(new PropertyValueFactory<>("carType"));
		numberOfSeats.setCellValueFactory(new PropertyValueFactory<>("numberOfSeats"));
		dailyPrice.setCellValueFactory(new PropertyValueFactory<>("dailyPrice"));
		make.setCellValueFactory(new PropertyValueFactory<>("make"));
		manufacturedYear.setCellValueFactory(new PropertyValueFactory<>("manufacturedYear"));



		System.out.println(vehicles.size());
		imageView.setItems(null);
		imageView.setItems(vehicles);
//		imageView.setItems(vehicles);
		
	}
	
	@FXML
	public void loadData(){
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
	}


}
