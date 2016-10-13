package application;

import java.io.IOException;

import javafx.fxml.FXML;

public class MainController {


	private Main main;
	
	@FXML
	public void showMain() throws IOException{
		
		main.goToHome();
		
	}
	
	@FXML
	public void showAddVehicle(){
		main.showAddVechileScene();
	}
	
	@FXML
	public void listAddVehicle(){
		main.listAddVechileScene();
	}
	
	@FXML
	public void selectAddVehicle() throws IOException{
		main.selectAddVechileScene();
	}
}
