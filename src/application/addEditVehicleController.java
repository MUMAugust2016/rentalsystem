package application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addEditVehicleController {

	@FXML
	private ComboBox type;
	
	@FXML
	private TextField plate;
	
	@FXML
	private TextField make;
	
	@FXML
	private TextField year;
	
	@FXML
	private Label label;
	
	public addEditVehicleController(){
		/*type = type.getValue();	
		plate= plate.getText();
		make = make.getText();
		year = year.getText();*/
	}
	
	public void add(){
		//
		String t = type.getValue() + plate.getText() + make.getText() + year.getText();
		label.setText(t);
	}
	
	
	
}
