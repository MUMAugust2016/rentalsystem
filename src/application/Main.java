package application;
	
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application implements Initializable {
	
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	
	
	@Override
	public void start(Stage myPrimaryStage) throws IOException {
		primaryStage = myPrimaryStage;
		primaryStage.setTitle("ABC Rental System");
		showMainView();
		showMainItems();
		Scene scene = new Scene(mainLayout, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	private void showMainView() throws IOException{
		try {
			FXMLLoader loader = new FXMLLoader();
			//loader.setLocation(getClass().getResource("../view/veichle/addEditVehicle.fxml"));	
			loader.setLocation(getClass().getResource("MainView.fxml"));
			//loader.load(Main.class.getResource("MainView.fxml"));
			mainLayout = loader.load();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	private void showMainItems() throws IOException {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../view/reservation/mainReservation.fxml"));
			BorderPane borderPain = loader.load();
			mainLayout.setCenter(borderPain);
			/*Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.show();*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
	}

	public static void showReservationSummaryScene() throws IOException {
		// TODO Auto-generated method stub

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/reservation/summaryReservation.fxml"));
			BorderPane summary = loader.load();
			mainLayout.setCenter(summary);
		
		
	}

	public static void goToHome() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../view/reservation/mainReservation.fxml"));		
		BorderPane home = loader.load();
		mainLayout.setCenter(home);
		
		
	}
	
	public static void showSelectVehicleForReservation() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../view/reservation/selectVehiclesForReservation.fxml"));		
		BorderPane home = loader.load();
		mainLayout.setCenter(home);
	}

	

	public void showAddVechileScene() {
		// TODO Auto-generated method stub
		
	}

	public void listAddVechileScene() {
		// TODO Auto-generated method stub
		
	}

	public static void selectAddVechileScene() throws IOException {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		//loader.setLocation(Main.class.getResource("../view/vehile/listVehicle.fxml"));
		loader.setLocation(Main.class.getResource("listVehicle.fxml"));

		BorderPane listVeichles = loader.load();
		mainLayout.setCenter(listVeichles);
		System.out.println("it reaches here");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}


}
